package finalproject.Ger_garage.Repositories;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

import finalproject.Ger_garage.Models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import finalproject.Ger_garage.Models.Booking;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Integer>{


	public Collection<Booking> findByUser(User user);
	public void deleteById(Integer id);

//	@Query("SELECT b FROM Booking b WHERE b.bookingDate.date > DATE_SUB(NOW(), INTERVAL 1 DAY) ORDER BY score DESC")
//	@Query("SELECT b FROM Booking b WHERE b.bookingDate.date>'2020-08-04'")
//	@Query("SELECT b FROM Booking b WHERE YEAR(b.bookingDate.date) = YEAR(NOW()) AND MONTH(date) = MONTH(NOW()) AND DAY(date) = DAY(NOW()")
//	public Iterable<Booking> findAll();
//	@Query("SELECT p FROM Booking p WHERE p.status='BOOKED'")
//	public Collection<Booking> findAll();


	//checking booking with the same date and time
	@Query(value = "SELECT * FROM booking_request WHERE date = :newDate AND time = :newTime", nativeQuery = true)
	public Booking findByDateAndTime(@Param("newDate") LocalDate date, @Param("newTime")  LocalTime time);

//	@Query(value = "SELECT * FROM booking_request WHERE date > DATE_SUB(NOW(), INTERVAL 1 DAY) ORDER BY date DESC", nativeQuery = true)

	//current month
	@Query(value = "SELECT * FROM booking_request WHERE EXTRACT(MONTH FROM date) =  EXTRACT(MONTH FROM CURRENT_DATE) ORDER BY date ASC", nativeQuery = true)
	public Iterable<Booking> thisMonthBookings();

	//current week
	@Query(value = "SELECT * FROM booking_request WHERE EXTRACT(WEEK FROM date) = EXTRACT(WEEK FROM CURRENT_DATE) ORDER BY date ASC", nativeQuery = true)
	public Iterable<Booking> thisWeekBookings();


	//current day
	@Query(value = "SELECT * FROM booking_request WHERE EXTRACT(DAY FROM date) = EXTRACT(DAY FROM CURRENT_DATE)", nativeQuery = true)
	public Iterable<Booking> todayBookings();

	//bookings on a specific day
	@Query(value = "SELECT * FROM booking_request WHERE date = :pickedDay", nativeQuery = true)
	public Iterable<Booking> dayPickerBookings(@Param("pickedDay") LocalDate date);

	//bookings of specific mechanic on specific day
	@Query(value = "SELECT * FROM booking_request WHERE date = :pickedDay AND MECHANIC_ID = :mechanic", nativeQuery = true)
	public List<Booking> mechanicBookings(@Param("pickedDay") LocalDate date,@Param("mechanic")  Integer Id);

//	public Booking findByVehicle_id();
}
