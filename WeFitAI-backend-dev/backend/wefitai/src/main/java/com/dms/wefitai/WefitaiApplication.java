package com.dms.wefitai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class WefitaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WefitaiApplication.class, args);
	}

}
