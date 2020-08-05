package finalproject.Ger_garage.DeafultData;

import finalproject.Ger_garage.Models.Role;
import finalproject.Ger_garage.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

//@Component
public class DefaultRoles {
//    @Autowired
    RoleRepository roleRepository;


    public DefaultRoles(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

//    @Bean
    public void createDefaultRoles(){
      Role admin = new Role();
        admin.setId(1);
      admin.setName("ROLE_ADMIN");

        Role user = new Role();
        user.setId(2);
        user.setName("ROLE_USER");

        roleRepository.save(admin);
        roleRepository.save(user);
    }

    public RoleRepository getRoleRepository() {
        return roleRepository;
    }

    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
}
