package org.sid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ManagementLogerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagementLogerServiceApplication.class, args);
	}

}
