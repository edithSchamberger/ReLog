package ar.edu.undef.fie.api.Relog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class RelogApplication {

	public static void main(String[] args) {
		SpringApplication.run(RelogApplication.class, args);
	}

}
