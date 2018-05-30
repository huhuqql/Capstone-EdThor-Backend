package org.cmu.edthor.capstone.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan("org.cmu.edthor")
@EnableMongoRepositories("org.cmu.edthor.capstone.repository")
public class Bootstrap {
	public static void main(String[] args) {
		SpringApplication.run(Bootstrap.class);
	}
}
