package finalproject.Ger_garage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = {"finalproject.Models"})
//@EntityScan(basePackages = {"finalproject.Models"})
//@ComponentScan("finalproject*")
public class GerGarageApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerGarageApplication.class, args);
	}

}
