package finalproject.Ger_garage.Security;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	/**
	 * we have configured view controllers to specify which view to render for which URL. 
	 */
	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/user/users").setViewName("users");
		registry.addViewController("/signup").setViewName("signup");
//		registry.addViewController("/user/update").setViewName("update");
//		registry.addViewController("/user/details").setViewName("details");
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/login").setViewName("login");
	}
	
	/**
	 * to enable using the Thymeleaf Spring Security dialect.
	 * @return
	 */
	@Bean
    public SpringSecurityDialect securityDialect() {
         return new SpringSecurityDialect();
    }

}