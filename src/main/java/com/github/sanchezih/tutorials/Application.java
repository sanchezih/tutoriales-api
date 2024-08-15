package com.github.sanchezih.tutorials;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * A single @SpringBootApplication annotation can be used to enable those three
 * features, that is:
 * 
 * @EnableAutoConfiguration: enable Spring Boot’s auto-configuration mechanism
 * 
 * @ComponentScan: enable @Component scan on the package where the application
 *                 is located (see the best practices)
 * 
 * @SpringBootConfiguration: enable registration of extra beans in the context
 *                           or the import of additional configuration classes.
 *                           An alternative to Spring’s standard @Configuration
 *                           that aids configuration detection in your
 *                           integration tests.
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
