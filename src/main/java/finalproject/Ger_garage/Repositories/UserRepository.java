package finalproject.Ger_garage.Repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import finalproject.Ger_garage.Models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	User findByEmail(String email);
//	Optional<User>findByEmailOption(String email);
}
