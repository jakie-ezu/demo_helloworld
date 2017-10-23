package com.accenture.microservices.poc;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoHelloworldApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoHelloworldApplication.class, args);
	}
	
	  @Bean
	    public FilterRegistrationBean correlationHeaderFilter() {
	        FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
	        filterRegBean.setFilter(new CorrelationHeaderFilter());
	        filterRegBean.setUrlPatterns(Arrays.asList("/*"));

	        return filterRegBean;
	    }
}
