package com.mycom.demo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

 

public class HelloWorldTest {
	
	@Test
	public void test() {
		assertThat(1+1 , equalTo(2));
	}

}
