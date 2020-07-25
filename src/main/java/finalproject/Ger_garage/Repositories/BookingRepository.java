package finalproject.Ger_garage.Repositories;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import finalproject.Ger_garage.Models.Booking;
import finalproject.Ger_garage.Models.Vehicle;


public interface BookingRepository extends CrudRepository<Booking, Integer>{


	public Collection<Booking> findByUserId(Integer userId);

	public Booking findTopByBookingDateDate(LocalDate date);
	public Booking findTopByBookingDateTime(LocalTime time);


//	public Collection<Booking> findByBookingDate(LocalDate date);
//	public Booking findByUserId(Integer userId);
}
