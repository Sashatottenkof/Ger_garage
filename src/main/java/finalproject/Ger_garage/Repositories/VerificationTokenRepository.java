package finalproject.Ger_garage.Repositories;


import finalproject.Ger_garage.Models.User;
import finalproject.Ger_garage.Models.VerificationToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenRepository extends CrudRepository<VerificationToken, Integer> {

    public VerificationToken findByUser(User user);
    public VerificationToken findByToken(String token);
}
