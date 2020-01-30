package com.rail.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rail.config.RailConfig;
import com.rail.core.Station;
import com.rail.dao.StationList;
 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RailConfig.class)
public class BasicServiceTest {
	
	@Autowired
	//@Qualifier("serviceGood")
	private BasicService service;
	
	@Autowired
	//@Qualifier("serviceGood")
	private BasicService serviceGood;

	@Test
	public void testService() {
		Collection<Station> list = service.getAll();
		assertEquals(6, list.size()); //adding one later on
		list.stream().forEach(System.out::println);
	}
	@Test
	public void testServiceIndividual() {
		Station station = service.get(2);	
		assertEquals("Bristol Temple Meads", station.getName());
		System.out.println(station);
	}
	
	@Test
	public void testScope() {
		assertNotSame(service, serviceGood);
	}
	
	@Autowired StationList stations;
	public void testSPEL() {
		assertEquals(2, stations.getNetworkRail());
	}

}
