package finalproject.Ger_garage.Security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import finalproject.Ger_garage.Models.User;
import finalproject.Ger_garage.Repositories.UserRepository;

@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Spring Security uses the UserDetailsService interface,
     * which contains the loadUserByUsername(String username) method to look up UserDetails for a given username.
     * The UserDetails interface represents an authenticated user object and Spring Security provides
     * an out-of-the box implementation of org.springframework.security.core.userdetails.User.
     * Now we implement a UserDetailsService to get UserDetails from database.
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {


        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Email " + email + " not found");
        }

        /**
         * We can return User  based on 2 types of constructor, it depends on how much information we want to return
         */
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.isEnabled(), user.isAccountNonExpired(),
                user.isCredentialsNonExpired(), user.isAccountNonLocked(), user.getAuthorities());
    }

}