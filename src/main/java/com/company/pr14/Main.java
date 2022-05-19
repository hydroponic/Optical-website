package com.company.pr14;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@Slf4j
@EnableAspectJAutoProxy
@ComponentScan({ "com.company.pr14.*" })
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		log.info("Application started");
	}
}

