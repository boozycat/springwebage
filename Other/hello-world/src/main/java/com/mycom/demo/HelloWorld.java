package com.mycom.demo;

import org.apache.log4j.Logger;

public class HelloWorld {
    //java -cp hello-world-0.0.1-SNAPSHOT.jar com.mycom.demo.HelloWorld
	//java -cp hello-world-0.0.2-SNAPSHOT-jar-with-dependencies.jar com.mycom.demo.HelloWorld
	private static Logger log = Logger.getLogger("HelloWorld");
	public static void main(String[] args) {
		System.out.println("Hello World");
		log.info("the message was printed");
		log.debug("debugging");
	}
	 
}
