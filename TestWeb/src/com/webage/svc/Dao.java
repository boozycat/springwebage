package com.webage.svc;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Singleton;
@Singleton
public class Dao {
	
	static Map<Integer, Course> map= new HashMap<Integer, Course>();
	static {
		map.put(1, new Course(1, "Java Web Services", "Dallas"));
		map.put(2, new Course(2, "Spring Dependency Injection", "Plano"));
		map.put(3, new Course(3, "Maven", "Richardson"));
	}
	public Course get(int id) {
		return map.get(id);
	}

}
