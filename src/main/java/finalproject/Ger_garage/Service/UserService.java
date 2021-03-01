package finalproject.Ger_garage.Service;

import finalproject.Ger_garage.Controllers.SignupController;
import finalproject.Ger_garage.DTO.UserUpdateDTO;
import finalproject.Ger_garage.Models.User;
import finalproject.Ger_garage.Repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class UserService {

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    // email service
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private VerificationTokenService verificationTokenService;
    // to get log in case of error
    private Logger logger = LoggerFactory.getLogger(SignupController.class);



    public Iterable <User> findAll(){return  userRepository.findAll();}
    /**
     * Find if such email already exists
     *
     * @param Email
     * @return
     */
    public User findByEmail(String Email) {
        return userRepository.findByEmail(Email);
    }

    /**
     * Delete user
     * @param id
     */
    public void deleteById(Integer id) { userRepository.deleteById(id);}
    /**
     * Find if such UserName already exists
     *
     * @param userName
     * @return
     */
    public User findByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }

    /**
     * Saving user into database
     * it's done to separate registration and activation saving
     * @param user
     * @return
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * one more option for deleting user
     * @param user
     */

    public void deleteUser(User user) {userRepository.delete(user); }

    /**
     * Saving User in a database
     *
     * @param user
     * @return
     */
    public User registration(User user) {


        //use passwordEncoder to encrypt a password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        //disables new user until verified
        user.setEnabled(false);

        // then save a user into database
        Optional<User> saved = Optional.of(saveUser(user));

        // create and save verification token if user is saved
        saved.ifPresent(u -> {
            try{
                String token = UUID.randomUUID().toString();
                verificationTokenService.saveToken(saved.get(),token);

                //send verification email
                notificationService.sendVerificationEmail(u);

            }
            catch(Exception e){
                e.printStackTrace();
                // if email is not send, delete the token and user
               verificationTokenService.deleteTokenByUser(user);
               deleteUser(user);
            }
        });

        return findByEmail(user.getEmail());
    }

    /**
     * Update user
     * @param user
     * @param userUpdateDTO
     * @return
     */
    public User update(User user,UserUpdateDTO userUpdateDTO ) {

        user.setUsername(userUpdateDTO.getUsername());
        user.setFirst_name(userUpdateDTO.getFirst_name());
        user.setLast_name(userUpdateDTO.getLast_name());
        user.setPassword(passwordEncoder.encode(userUpdateDTO.getPassword()));
        user.setPhone_number(userUpdateDTO.getPhone_number());
        user.setDate_of_birth(userUpdateDTO.getDate_of_birth());
        user.setGender(userUpdateDTO.getGender());

        return saveUser(user);
    }

    /**
     * send greeting notification after registration
     *
     * @param user
     */
    public void GreetingNotification(User user) {
        try {
            notificationService.sendGreeting(user);
        } catch (MailException e) {
            //catch error
            logger.info("Error Sending Email: " + e.getMessage());
        }
    }

}
