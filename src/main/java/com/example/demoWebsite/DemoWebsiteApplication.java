package com.example.demoWebsite;

import com.example.demoWebsite.Controller.DemoController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.example.demoWebsite"})
public class DemoWebsiteApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoWebsiteApplication.class, args);

	}

}
