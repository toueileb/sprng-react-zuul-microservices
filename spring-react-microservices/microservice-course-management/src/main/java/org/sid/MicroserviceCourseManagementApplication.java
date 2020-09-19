package org.sid;

import org.sid.model.Course;
import org.sid.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.time.LocalDate;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class MicroserviceCourseManagementApplication implements CommandLineRunner {
	@Autowired
	private CourseRepository courseRepository;


	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCourseManagementApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Course course = new Course();
		course.setPublishDate(LocalDate.now());
		course.setTitle("Course 1");
		course.setSerialNumber("nom44444");
		course.setId(1l);
		course.setCategory("Category 1");
		course.setAuthor("Toueileb Mohamed");
		courseRepository.save(course);
	}
}
