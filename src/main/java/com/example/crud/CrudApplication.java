package com.example.crud;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

		setSystemProperty(dotenv, "DB_USER");
		setSystemProperty(dotenv, "DB_PASS");
		setSystemProperty(dotenv, "API_KEY");

		SpringApplication.run(CrudApplication.class, args);
	}

	private static void	setSystemProperty(Dotenv dotenv, String key) {
		String value = dotenv.get(key);
		if (value != null) {
			System.setProperty(key, value);
		}
	}
}
