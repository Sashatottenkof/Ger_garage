package finalproject.Ger_garage.Controllers;


import javax.validation.Valid;

import finalproject.Ger_garage.Models.Role;
import finalproject.Ger_garage.Models.VerificationToken;
import finalproject.Ger_garage.Service.UserService;
import finalproject.Ger_garage.Service.VerificationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import finalproject.Ger_garage.Models.User;

import java.sql.Timestamp;
import java.util.Arrays;


@Controller
@RequestMapping("signup")
public class SignupController {

    @Autowired
    private UserService userService;
    @Autowired
    private VerificationTokenService verificationTokenService;

    /**
     * display sign up form for user
     *
     * @param model
     * @return
     */
    @GetMapping
    public String displayAddUserForm(Model model) {
        model.addAttribute(new User());
//		model.addAttribute(Gender.values());
        return "signup/signup";
    }

    /**
     * sign up a new user
     *
     * @param user
     * @return
     */
    @PostMapping
    public String addUser(@ModelAttribute @Valid User user, Errors errors, Model model) {

        //checking if a user with this email has already existed
        User existingEmail = userService.findByEmail(user.getEmail());
        User existingUsername = userService.findByUsername(user.getUsername());

        if (existingEmail != null) {
            errors.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (existingUsername != null) {
            errors.rejectValue("username", null, "There is already an account registered with that username");
        }

        if (!user.getPassword().equals(user.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", null, "Passwords do not match");
        }

        // if any errors, we reload the "sign up" page
        if (errors.hasErrors()) {
            return "signup/signup";
        }

        // we have to give a role to the user, by default it is "ROLE_USER"
        user.setRoles(Arrays.asList(new Role("ROLE_USER")));


        // save user into database
        User newUser = userService.registration(user);


        // if registration went wrong (verification email weren't send) send error message)
        if (newUser == null) {
            model.addAttribute("errorMessage", "Something went wrong, verification email weren't send.");
            return "signup/response";
        }



        //After registration user goes to Success page that notifies him that email is send to his mail
        model.addAttribute("successMessage", "Verification email has been send. Please check your mailbox.");
        return "signup/response";
    }


    /**
     * verify token
     * Display activation page
     *
     * @param token
     * @param model
     * @return
     */
    @GetMapping("activation")
    public String activation(@RequestParam("token") String token, Model model) {

        VerificationToken verificationToken = verificationTokenService.findByToken(token);
        if (verificationToken == null) {
            model.addAttribute("massage", "Your verification token is invalid.");
        } else {

            User user = verificationToken.getUser();

            //if user is not activated
            if (!user.isEnabled()) {

                // get the current timestamp
                Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

                //check if the token is expired
                if (verificationToken.getExpiryDate().before(currentTimestamp)) {
                    model.addAttribute("message", "Your verification token is expired.");
                } else {

                    //the token is valid
                    // activate the user account
                    user.setEnabled(true);
                    // update the user
                    userService.saveUser(user);
                    model.addAttribute("message", "Your account is successfully activated.");
                    //send greeting email
                    userService.GreetingNotification(user);
                }

            } else {
                // the user account is already activated
                model.addAttribute("message", "Your account is already activated.");
            }
        }

        return "signup/activation";
    }
}