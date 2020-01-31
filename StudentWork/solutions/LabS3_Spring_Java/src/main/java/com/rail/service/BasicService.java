package com.rail.service;

import java.util.Collection;

import com.rail.core.Station;

public interface BasicService {
	
	 Collection<Station> getAll();
	 Station get(int id);
	 String getServiceName();
}
