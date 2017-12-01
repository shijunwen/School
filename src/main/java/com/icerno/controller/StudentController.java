package com.icerno.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.icerno.dao.StudentDao;
import com.icerno.entity.School;
@Controller
@RequestMapping("/school")
public class StudentController {
	@Resource
	private StudentDao studentDao;
	
	/*
	 * 分页显示数据
	 * 
	 * 
	 * 
	 * */
@RequestMapping("/list")
	@ResponseBody
	public ModelAndView getList(School school,@RequestParam(value="pn",defaultValue="1")Integer pn) {
		ModelAndView mav=new ModelAndView();
		Pageable pageable=new PageRequest(pn, 5);
		Page<School> page=studentDao.findAll(pageable);
		mav.addObject("pageInfo", page);
		mav.setViewName("list2");
		return mav;
	}
	
	
	
	
	/* 
	 * 
	 * 分页查询
	 * */
	
/*@RequestMapping("/list")
	public ModelAndView getEmps(School school,@RequestParam(value="pn",defaultValue="1")Integer pn) {
		ModelAndView mav=new ModelAndView();
		PageHelper.startPage(pn, 5,true);
		List<School> list= studentDao.findAll();
		PageInfo<School> page = new PageInfo<School>(list,5);
		
		//用PageInfo对结果进行包装，只需要将pageInfo交给页面
		 mav.addObject("pageInfo", page);
		mav.setViewName("list");
		return mav;
	}*/
	
	/* 
	 * 
	 * 动态查询学籍信息
	 * 
	 * */
	@RequestMapping("/list2")
	public ModelAndView list2(School school,BindingResult bindingResult,@RequestParam(value="pn",defaultValue="1")Integer pn) {
		ModelAndView mav=new ModelAndView();
		PageHelper.startPage(pn, 5);
		List<School> schoollist=studentDao.findAll(new Specification<School>() {
			@Override
			public Predicate toPredicate(Root<School> root, CriteriaQuery<?> arg1, CriteriaBuilder cb) {
				Predicate predicate=cb.conjunction();
				if(school!=null) {
					if(school.getProfessional()!=null && !"".equals(school.getProfessional())){
						predicate.getExpressions().add(cb.like(root.get("professional"), "%"+school.getProfessional()+"%"));
					}
						
					if(school.getName()!=null && !"".equals(school.getName())){
						predicate.getExpressions().add(cb.like(root.get("name"), "%"+school.getName()+"%"));
					}
				}
				return predicate;
			}
		});
		PageInfo<School> page = new PageInfo<School>(schoollist,5);
		mav.addObject("pageInfo", page);
		mav.setViewName("list");
		return mav;
	}
	
	/* 
	 * 
	 *  添加学籍信息
	 *  
	 *  */
	
	@PostMapping("/add")
	public String add(School school,BindingResult bindingResult) {
		studentDao.save(school);
		return "forward:/school/list";
	}

	/* 
	 * 删除学籍信息
	 * 
	 * */
	@GetMapping("/delete")
	public String delete(Integer id) {
		studentDao.delete(id);
		return "forward:/school/list";
	}
	/*
	 * 根据id查找学籍信息
	 *  
	 *  
	 *  */
	
	@RequestMapping("/preUpdate/{id}")
	public ModelAndView preUpdate(@PathVariable("id")Integer id){
		ModelAndView mav=new ModelAndView();
		mav.addObject("school", studentDao.getOne(id));
		mav.setViewName("schoolUpdate");
		return mav;
	}
	/* 
	 * 更新学籍信息
	 * */
	
	@PostMapping(value="/update")
	public String update(School school,BindingResult bindingResult){
		studentDao.save(school);
		return "forward:/school/list";
	}
	
	

}
