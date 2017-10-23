/**
 * 
 */
package com.accenture.microservices.poc.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author j.venugopalan
 *
 */

@SpringBootApplication
public class HelloWorldService {
	
	public String getGreetingsString(){
		return "Hello World, Welcome to MS";
	}

}
