package com.rail.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

import com.rail.core.StationConversion;
import com.rail.service.BasicService;
import com.rail.service.BasicServiceImpl;

@ComponentScan(basePackages="com.rail.dao")
@Import(DaoConfig.class)
@PropertySource("application.properties")
public class RailConfig {
	
	@Autowired DaoConfig config;
	
	@Bean(name="serviceGood") @Primary
	@Scope("prototype")
	BasicService getService() {
		BasicServiceImpl impl =  new BasicServiceImpl();
		impl.setDao(config.getDao());
		return impl;
	}
	
	@Bean(name="serviceNull")
	BasicService getServiceNull() {
		return null;
	}
	
	 @Bean
	 static PropertySourcesPlaceholderConfigurer configuyrer() {
		 return new PropertySourcesPlaceholderConfigurer();
	 }
	 
	 @Bean
     public ConversionService conversionService () {
         DefaultConversionService service = new DefaultConversionService();
         service.addConverter(new StationConversion());
         return service;
     }

}
