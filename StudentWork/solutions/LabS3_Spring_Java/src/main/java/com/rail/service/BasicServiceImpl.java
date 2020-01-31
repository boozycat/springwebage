package com.rail.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;

import com.rail.core.Station;
import com.rail.dao.BasicDao;
 
public class BasicServiceImpl implements BasicService{
 
	private BasicDao dao;
	@Value("${serv.name}")
	private String serviceName;

	@Override
	public Collection<Station> getAll() {
 		return dao.get();
	}

	@Override
	public Station get(int id) {
 		return dao.get().stream().filter(p-> p.getId() == id).findFirst().get();
	}

	public void setDao(BasicDao dao) {
		this.dao = dao;
	}

	public String getServiceName() {
		return serviceName;
	}

	 

}
