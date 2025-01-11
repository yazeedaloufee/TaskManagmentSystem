package com.example.demo;

import com.example.demo.auth.AuthenticationService;
import com.example.demo.auth.RegisterRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.example.demo.enums.Role.ADMIN;
import static com.example.demo.enums.Role.MANAGER;

@SpringBootApplication
public class DemoApplication {
	@Value("${application.security.jwt.secret-key}")
	private static String SECRET_KEY;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println(SECRET_KEY);
	}
	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service
	) {
		return args -> {
			var admin = RegisterRequest.builder()
					.firstname("Admin")
					.lastname("Admin")
					.email("admin@mail.com")
					.password("password")
					.role(ADMIN)
					.build();
			System.out.println("Admin token: " + service.register(admin).getAccessToken());

			var manager = RegisterRequest.builder()
					.firstname("Admin")
					.lastname("Admin")
					.email("manager@mail.com")
					.password("password")
					.role(MANAGER)
					.build();
			System.out.println("Manager token: " + service.register(manager).getAccessToken());

		};
	}

}
