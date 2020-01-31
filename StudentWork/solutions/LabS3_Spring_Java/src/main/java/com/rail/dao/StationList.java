package com.rail.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.rail.core.Station;
 
public class StationList {
	
	 
	
	private static List<Station> list = new ArrayList<>();
	
	static {
		list.add(new Station(1, 1392,"Exeter St Davids","Great Western RailWay"));
		list.add(new Station(2, 117,"Bristol Temple Meads","Network Rail"));
		list.add(new Station(3, 978,"Glouceter","Great Western RailWay"));
		list.add(new Station(4, 151,"Liverpool Lime Street","Network Rail"));
		list.add(new Station(5, 1270,"Crewe","Avanti West Coast"));
	}

	public   List<Station> getList() {
		return list;
	}
	
	 
}
