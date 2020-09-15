package org.sid.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ManagementCourseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagementCourseServiceApplication.class, args);
	}

}
