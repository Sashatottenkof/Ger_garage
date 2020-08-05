package finalproject.Ger_garage.Repositories;

import finalproject.Ger_garage.Models.Role;
import finalproject.Ger_garage.Models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
}
