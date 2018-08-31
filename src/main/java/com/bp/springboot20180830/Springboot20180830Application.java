package com.bp.springboot20180830;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.bp.springboot20180830.entity")
@EnableJpaRepositories("com.bp.springboot20180830.repos")
@SpringBootApplication
/**
 * Ref : https://www.baeldung.com/spring-boot-start
 */
public class Springboot20180830Application {

	public static void main(String[] args) {
		SpringApplication.run(Springboot20180830Application.class, args);
	}
}
