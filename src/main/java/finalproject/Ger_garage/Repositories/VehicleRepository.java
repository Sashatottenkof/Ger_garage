package finalproject.Ger_garage.Repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import finalproject.Ger_garage.Models.Vehicle;



public interface VehicleRepository extends CrudRepository<Vehicle, Integer>{

	public Collection<Vehicle> findByUserId(Integer userId);
//	public Vehicle findByUserId(Integer userId);

}
