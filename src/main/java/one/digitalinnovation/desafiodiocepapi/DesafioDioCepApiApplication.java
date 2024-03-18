package one.digitalinnovation.desafiodiocepapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DesafioDioCepApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioDioCepApiApplication.class, args);
	}

}
