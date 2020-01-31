package com.rail.dao;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.rail.core.Station;

public class BasicDaoImpl implements BasicDao{
	
 
	private StationList stations;

	@Override
	public Collection<Station> get() {
	 	return stations.getList();
	}

	public void setStations(StationList stations) {
		this.stations = stations;
	}

 
}
