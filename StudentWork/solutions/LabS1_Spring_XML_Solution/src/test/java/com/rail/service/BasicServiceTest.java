package com.rail.service;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rail.core.Station;
import com.rail.dao.StationList;
 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="classpath:beans.xml")
public class BasicServiceTest {
	
	@Autowired
	private BasicService service;
 
	@Test
	public void testService() {
		Collection<Station> list = service.getAll();
		assertEquals(5, list.size());  
		list.stream().forEach(System.out::println);
	}
	@Test
	public void testServiceIndividual() {
		Station station = service.get(2);	
		assertEquals("Bristol Temple Meads", station.getName());
		System.out.println(station);
	}
	
	 
	
	@Autowired StationList stations;
	public void testSPEL() {
		assertEquals(2, stations.getNetworkRail());
	}

}
