package finalproject.Ger_garage.Controllers;

import java.util.Arrays;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import finalproject.Ger_garage.Models.Role;
import finalproject.Ger_garage.Models.User;
import finalproject.Ger_garage.Repositories.UserRepository;

@Controller

@RequestMapping("signup")
public class SignupController {

	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepository;
	
	/**
	 * display sign up form for user
	 * @param model
	 * @return
	 */
	@GetMapping
	public String displayAddUserForm(Model model) {
		model.addAttribute(new User());
//		model.addAttribute(Gender.values());
	 return "/signup";
	}
	
	/**
	 * sign up a user
	 * @param user
	 * @return
	 */
	@PostMapping
	public String addUser(@ModelAttribute @Valid User user, Errors errors) {
		
		//checking if a user with this email has already existed
		User existing = userRepository.findByEmail(user.getEmail());
        if (existing != null) {
        	errors.rejectValue("email", null, "There is already an account registered with that email");
        }

		// if any errors, we reload the "sign up" page
		if(errors.hasErrors()) {
			return "/signup";
		}
		// we have to give a role to the user, by default it is "ROLE_USER"
		user.setRoles(Arrays.asList(new Role("ROLE_USER")));
		// then save a user into database
		userRepository.save(user);
		return "redirect:signup?success";
	}
}