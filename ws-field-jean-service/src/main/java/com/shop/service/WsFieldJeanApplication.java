package com.shop.service;

import com.shop.service.sources.PostgresConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Import(PostgresConfig.class)
public class WsFieldJeanApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsFieldJeanApplication.class, args);
	}

}
