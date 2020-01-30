package com.rail.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.rail.dao.BasicDao;
import com.rail.dao.BasicDaoImpl;
import com.rail.service.BasicService;
import com.rail.service.BasicServiceImpl;

 @Configuration //need this as autowired into another class
public class DaoConfig {
 
	@Bean
	BasicDao getDao() {
		return new BasicDaoImpl();
	}
	 
}
