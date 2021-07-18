package br.com.comicsmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ComicsManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComicsManagementApplication.class, args);
	}

}
