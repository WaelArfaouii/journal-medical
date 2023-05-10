package com.arfaouiKallebi.JournalWeb;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JournalWebApplication {

	public static void main(String[] args) {


		SpringApplication.run(JournalWebApplication.class, args);
	}
	public ObjectMapper getObjectMapper() {

		return new ObjectMapper();

	}

}
