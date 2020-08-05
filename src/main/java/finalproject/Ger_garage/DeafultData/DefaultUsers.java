package finalproject.Ger_garage.DeafultData;


import finalproject.Ger_garage.Enums.Gender;
import finalproject.Ger_garage.Models.Role;
import finalproject.Ger_garage.Models.User;
import finalproject.Ger_garage.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//@Component
public class DefaultUsers {
//    @Autowired
    UserRepository userRepository;

//    @Autowired
    private PasswordEncoder passwordEncoder;

    public DefaultUsers() {
    }

    public DefaultUsers(UserRepository userRepository, List<User> defaultUsers) {
        this.userRepository = userRepository;

    }
//    @Bean
//    public  void changePassword(){
////      Optional<User> user =  userRepository.findById(1);
//        User admin = userRepository.findByEmail("admin@gmail.com");
//        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
//        admin.setUpdate_time(null);
//        User user = userRepository.findByEmail("user@gmail.com");
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setUpdate_time(null);
//        userRepository.save(admin);
//        userRepository.save(user);
//    }
//
//    @Bean
//    public void createDefaultUsers() {
//
//        User admin = new User();
//
//        admin.setId(1);
//        admin.setUsername("Admin");
//        admin.setEmail("admin@gmail.com");
//        admin.setPassword("1111");
//        admin.setFirst_name("Ger");
//        admin.setLast_name("Harrison");
//        admin.setGender(Gender.MALE);
//        admin.setDate_of_birth(LocalDate.of(1990, 1, 9));
//        admin.setRoles(Arrays.asList(new Role("ROLE_ADMIN")));
//        admin.setCreate_time(null);
//        admin.setUpdate_time(null);
//
//        User user = new User();
//        user.setId(2);
//        user.setUsername("User");
//        user.setEmail("user@gmail.com");
//        user.setPassword("2222");
//        user.setFirst_name("Ger");
//        user.setLast_name("Harrison");
//        user.setGender(Gender.MALE);
//        user.setDate_of_birth(LocalDate.of(1990, 1, 9));
//        user.setRoles(Arrays.asList(new Role("ROLE_USER")));
//        user.setCreate_time(null);
//        user.setUpdate_time(null);
//
//
//
//        userRepository.save(admin);
//        userRepository.save(user);
//    }


}
