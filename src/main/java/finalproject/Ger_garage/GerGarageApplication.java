package finalproject.Ger_garage;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
/**
 *  A single @SpringBootApplication annotation can be used to enable those three features
 * @Configuration @EnableAutoConfiguration @ComponentScan
 * */
//@EnableJpaRepositories(basePackages = {"finalproject.Models"})
//@EntityScan(basePackages = {"finalproject.Models"})
//@ComponentScan("finalproject*")
public class GerGarageApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerGarageApplication.class, args);
	}


}
