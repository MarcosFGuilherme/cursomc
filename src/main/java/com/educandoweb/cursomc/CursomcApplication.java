package com.educandoweb.cursomc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
//	@Autowired
//	private S3Service s3service;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		s3service.uploadFile("E:\\Temp\\fotos\\DS3.PNG");
	}
}
