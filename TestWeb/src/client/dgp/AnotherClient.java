package client.dgp;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import client.Course;
import client.HelloSvc;

public class AnotherClient {
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://localhost:8080/TestWeb/HelloSvc?wsdl");
		// 1st argument service URI, refer to wsdl document above
		// 2nd argument is service name, refer to wsdl document above
		QName qname = new QName("http://svc.webage.com/", "HelloSvcService");

		Service service = Service.create(url, qname);

		HelloSvc hello = service.getPort(HelloSvc.class);

		System.out.println(hello.sayHello("Pasha"));

		Course course = hello.getTrainingClass(2);
		System.out.printf("%-2d %-10s %-20s%n", course.getIdentifier(), course.getCity(), course.getName());

	}
}
