package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@SpringBootApplication

public class MsIplPlayerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsIplPlayerApplication.class, args);
	}

}
