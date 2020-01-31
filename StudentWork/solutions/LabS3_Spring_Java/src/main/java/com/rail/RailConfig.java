package com.rail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.rail.dao.BasicDao;
import com.rail.dao.BasicDaoImpl;
import com.rail.dao.StationList;
import com.rail.service.BasicService;
import com.rail.service.BasicServiceImpl;

@Configuration
@PropertySource("classpath:application.properties")
public class RailConfig {
	
	@Bean
	BasicService service() {
		BasicServiceImpl service = new BasicServiceImpl();
		service.setDao(dao());
		return service;
		
	}
	
	@Bean
	BasicDao dao() {
		BasicDaoImpl dao = new BasicDaoImpl();
		dao.setStations(new StationList());
		return dao;
	}
	
	@Bean 
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
	   return new PropertySourcesPlaceholderConfigurer();
	}


}
