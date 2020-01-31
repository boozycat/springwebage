package com.rail.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rail.core.Station;
import com.rail.dao.BasicDao;
 
public class BasicServiceImpl implements BasicService{
	@Autowired 
	private BasicDao dao;

	@Override
	public Collection<Station> getAll() {
 		return dao.get();
	}

	@Override
	public Station get(int id) {
 		return dao.get().stream().filter(p-> p.getId() == id).findFirst().get();
	}

	 

}
