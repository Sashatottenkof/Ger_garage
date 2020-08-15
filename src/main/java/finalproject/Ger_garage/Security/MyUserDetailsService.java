package finalproject.Ger_garage.Security;


import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
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
     *Spring Security uses the UserDetailsService interface, 
     *which contains the loadUserByUsername(String username) method to look up UserDetails for a given username.
     *The UserDetails interface represents an authenticated user object and Spring Security provides 
     *an out-of-the box implementation of org.springframework.security.core.userdetails.User.
     *Now we implement a UserDetailsService to get UserDetails from database.
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(userName);
        		 if (user != null) {
        			 new UsernameNotFoundException("Email " + userName + " not found");
        	   }
         return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
         getAuthorities(user));
        		 
    }


    private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
        String[] userRoles = user.getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }
    
}