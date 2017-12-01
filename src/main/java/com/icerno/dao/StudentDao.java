package com.icerno.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


import com.icerno.entity.School;

public interface StudentDao extends JpaRepository<School, Integer>,JpaSpecificationExecutor<School>{
	
	
}
