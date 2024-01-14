package com.shop.service;

import com.shop.service.sources.PostgresConfig;
import com.shop.service.sources.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({PostgresConfig.class, WebConfig.class})
public class WsFieldJeanApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsFieldJeanApplication.class, args);
	}

}
