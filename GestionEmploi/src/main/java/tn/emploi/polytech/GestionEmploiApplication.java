package tn.emploi.polytech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class GestionEmploiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(GestionEmploiApplication.class, args);

	}
}
