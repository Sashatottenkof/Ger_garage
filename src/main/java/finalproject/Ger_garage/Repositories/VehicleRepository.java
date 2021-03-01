package finalproject.Ger_garage.Repositories;

import java.util.Collection;


import finalproject.Ger_garage.Models.User;
import org.springframework.data.repository.CrudRepository;

import finalproject.Ger_garage.Models.Vehicle;
import org.springframework.stereotype.Repository;


@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Integer>{

	public Collection<Vehicle> findByUser(User user);
}
