package finalproject.Ger_garage.Controllers;


import java.security.Principal;
import java.util.Arrays;

import javax.validation.Valid;

import finalproject.Ger_garage.DTO.UserUpdateDTO;
import finalproject.Ger_garage.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import finalproject.Ger_garage.Models.Role;
import finalproject.Ger_garage.Models.User;
import finalproject.Ger_garage.Models.Vehicle;
import finalproject.Ger_garage.Repositories.UserRepository;
import finalproject.Ger_garage.Repositories.VehicleRepository;
import javassist.NotFoundException;

@Controller

@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * Show user details
     *
     * @param model
     * @return
     * @throws NotFoundException
     */

//	@GetMapping("details")
//	public String displayUser(  @AuthenticationPrincipal User currentUser, Model model) throws NotFoundException {
//		User user = (User) userRepository.findByEmail(currentUser.getUsername());
//		 model.addAttribute("userId", user);
////		userRepository.findById(id).ifPresent(user -> model.addAttribute("userId", user));
//		return "user/user";
//	}
    @GetMapping("details")
    public String displayUser(Principal principal, Model model) throws NotFoundException {
        User user = userService.findByEmail(principal.getName());
        model.addAttribute("userId", user);
//		userRepository.findById(id).ifPresent(user -> model.addAttribute("userId", user));
        return "user/user";
    }

    /**
     * show update from
     *
     * @param model
     * @return
     */
    @GetMapping("update")
    public String displayUpdateForm(Principal principal, Model model) {

        User user = userService.findByEmail(principal.getName());
        model.addAttribute("updatedUser", user);
        return "user/update-user";
    }
//	@GetMapping("update/{id}")
//	public String displayUpdateForm(@PathVariable("id") Integer id, Model model) {
//		
//		userRepository.findById(id).ifPresent(user -> model.addAttribute("userId", user));
////		model.addAttribute(Gender.values());
//	 return "user/update-user";
//	}

    /**
     * Update user details
     * "user" template needs a model to be displayed
     *
     * @param
     * @param errors
     * @param model
     * @return
     */
    @PostMapping("update")
    public String updateUser(@ModelAttribute("updatedUser") @Valid UserUpdateDTO userUpdateDTO, Errors errors, Principal principal, Model model) {

        User oldUser = userService.findByEmail(principal.getName());

        User existingUsername = userService.findByUsername(userUpdateDTO.getUsername());

        //check if such name already exists
        if (existingUsername != null && existingUsername.getUsername() != oldUser.getUsername()) {
            errors.rejectValue("username", null, "There is already an account registered with that username");
        }
        // validation on repeat password
        if (!userUpdateDTO.getPassword().equals(userUpdateDTO.getConfirmPassword())){
            errors.rejectValue("confirmPassword", null, "Passwords do not match");
        }

        // If the input is wrong it will sent a user object to display a template
        if (errors.hasErrors()) {
            model.addAttribute("updatedUser", userUpdateDTO);
            return "user/update-user";
        }



        userService.update(oldUser,userUpdateDTO);
        return "redirect:../details?success";
    }


//	@PostMapping("update/{id}")
//	public String updateUser( @PathVariable("id") Integer id, @ModelAttribute @Valid User user, Errors errors, Model model, Principal principal) {
//		
//		userRepository.findById(id).ifPresent(newUser -> model.addAttribute("userId", user));
//		if(errors.hasErrors()) {
//			user.setId(id);
//			return "user/update-user";
//		}
//		userRepository.save(user);
//		
//		return "user/user";
//	}


//	@GetMapping("/user/{id}")
//	public User getUser(@PathVariable Integer id) throws NotFoundException {
//		Optional<User> user = userRepository.findById(id);
//		if (user.isPresent()) {
//			return user.get();
//		} else {
//			throw new NotFoundException("User not found with id " + id);
//		}
//	}

//	@PutMapping("/user/{id}")
//	public String updateUser(@RequestBody User user, @PathVariable Integer id) {
//		 userRepository.findById(id)
//			      .map(oldUser -> {
//			    	  oldUser.setFirst_name(user.getFirst_name());
//			    	  oldUser.setLast_name(user.getLast_name());
//			        return userRepository.save(oldUser);
//			      });
//		 return "updated";
//		 
//			   
////		Optional<User> oldUser = userRepository.findById(id);
////		oldUser.get().setFirst_name(user.getFirst_name());
////		userRepository.save(oldUser.get());
////		return "Deleted";
//	}

//	@DeleteMapping("/user/{id}")
//	public String deleteUser(@PathVariable Integer id) {
//		userRepository.deleteById(id);
//		return "Deleted";


//	}
//	@GetMapping("users/{id}")
//	public String deleteUser(@PathVariable("id") Integer id) {
//	
//		userRepository.deleteById(id);
//
//		
//		return "redirect:";
//	}

//	@PostMapping("/add")
//	public String addUser(@RequestBody User user) {
//		userRepository.save(user);
//		return "Saved";
//	}


//	@GetMapping("/users")
//	public Iterable<User> getAllUsers() {
//		return userRepository.findAll();
//	}

}
