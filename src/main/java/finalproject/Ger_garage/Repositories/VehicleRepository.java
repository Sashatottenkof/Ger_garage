package finalproject.Ger_garage.Repositories;

import java.util.Collection;
import java.util.List;

import finalproject.Ger_garage.Models.User;
import org.springframework.data.repository.CrudRepository;

import finalproject.Ger_garage.Models.Vehicle;



public interface VehicleRepository extends CrudRepository<Vehicle, Integer>{

	public Collection<Vehicle> findByUser(User user);

//	public  Vehicle findByBookingId(Integer bookingId);
//	public Vehicle findByUserId(Integer userId);

}
