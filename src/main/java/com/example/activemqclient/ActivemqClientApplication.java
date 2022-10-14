package com.example.activemqclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

import java.util.Scanner;

@SpringBootApplication
@EnableJms
public class ActivemqClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivemqClientApplication.class, args);
	}

}
