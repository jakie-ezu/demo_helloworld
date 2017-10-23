/**
 * 
 */
package com.accenture.microservices.poc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.accenture.microservices.poc.service.HelloWorldService;

/**
 * @author j.venugopalan
 *
 */

@RestController
public class HelloworldController {
	
	@Bean
	RestTemplate restTemaplate(){
		return new RestTemplate();
	}
	
	@Autowired
	RestTemplate restTemplate;
	
	 @Autowired
	    private RestClient restClient;
	 
	 @Autowired
	 HelloWorldService helloWorldService;
	
	 
	private static final Logger log = LoggerFactory.getLogger(HelloworldController.class);
	private static final String URL = "http://localhost:8082/helloworld";
	
	@RequestMapping(value = "/greetings", method = RequestMethod.GET)
	public String getWelcomeMessage(){
		
		/*String response = restClient.getForString(URL);
		log.info("response from 2nd level Micorservice: "+response);*/
		String response = this.helloWorldService.getGreetingsString();
		log.info("Helloworld Micorservice-1 :  "+RequestCorrelation.getId());
		return response;
	}

}
