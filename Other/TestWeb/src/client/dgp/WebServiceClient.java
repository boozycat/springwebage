package client.dgp;

import java.net.MalformedURLException;

import client.Course;
import client.HelloSvc;
import client.HelloSvcService;
/*
 * 
 * wsimport -keep -p client C:\Users\domde\OneDrive\Documents\wildfly-10.1.0.Final\standalone\data\wsdl\TestWeb.war\HelloSvcService.wsdl
 */
public class WebServiceClient {
	
	public static void main(String[] args) throws MalformedURLException {
		HelloSvcService service = new HelloSvcService();
        HelloSvc port = service.getHelloSvcPort();
        String result = port.sayHello("Piper");
        System.out.println(result);
        
        Course course = port.getTrainingClass(2);
        System.out.printf("%-2d %-10s %-20s%n",course.getIdentifier(), course.getCity(), course.getName());
        
        course = port.getTrainingClass(3);
        System.out.printf("%-2d %-10s %-20s%n",course.getIdentifier(), course.getCity(), course.getName());
       
        
	}

}
