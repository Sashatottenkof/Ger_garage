package finalproject.Ger_garage.Repositories;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import finalproject.Ger_garage.Models.Booking;
import finalproject.Ger_garage.Models.Vehicle;


public interface BookingRepository extends CrudRepository<Booking, Integer>{

	public Collection<Booking> findByUserId(Integer userId);
}
