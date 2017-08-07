package br.com.renan.medicadastro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages =  "br.com.renan.medicadastro.dao")
@SpringBootApplication
public class MedicadastroApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicadastroApplication.class, args);
	}
}
