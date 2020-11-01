package com.company.config;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class CustomContainer {

	@Bean
	public TomcatServletWebServerFactory containerFactory() {
	    return new TomcatServletWebServerFactory() {
	        @Override
	        protected void customizeConnector(Connector connector) {
	            super.customizeConnector(connector);
	            connector.setParseBodyMethods("POST,PUT,DELETE");
	        }
	    };
	}
}
