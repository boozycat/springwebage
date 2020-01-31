package com.webage.svc;

import javax.inject.Inject;
import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
@HandlerChain(file="handler.xml")
public class HelloSvc {
	
	@WebMethod
	public String sayHello(String name) {
		return "Hello " + name;
	}
	
	@Inject private Dao dao;
	
	@WebMethod(operationName="getTrainingClass")
	public Course getCourse(@WebParam(name="courseId") int id) {
		return dao.get(id);
	}

}
