package finalproject.Ger_garage.Repositories;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import finalproject.Ger_garage.Models.Booking;
import org.springframework.data.repository.query.Param;


public interface BookingRepository extends CrudRepository<Booking, Integer>{


	public Collection<Booking> findByUserId(Integer userId);

//	@Query("SELECT b FROM Booking b WHERE b.bookingDate.date > DATE_SUB(NOW(), INTERVAL 1 DAY) ORDER BY score DESC")
//	@Query("SELECT b FROM Booking b WHERE b.bookingDate.date>'2020-08-04'")
//	@Query("SELECT b FROM Booking b WHERE YEAR(b.bookingDate.date) = YEAR(NOW()) AND MONTH(date) = MONTH(NOW()) AND DAY(date) = DAY(NOW()")
//	public Iterable<Booking> findAll();
//	@Query("SELECT p FROM Booking p WHERE p.status='BOOKED'")
//	public Collection<Booking> findAll();


	//checking bookink with the same date and time
	@Query(value = "SELECT * FROM booking_request WHERE DAY(date) = DAY(:newDate) AND TIME(time) = TIME(:newTime)", nativeQuery = true)
	public Booking findByDateAndTime(@Param("newDate") LocalDate date, @Param("newTime")  LocalTime time);

//	@Query(value = "SELECT * FROM booking_request WHERE date > DATE_SUB(NOW(), INTERVAL 1 DAY) ORDER BY date DESC", nativeQuery = true)

	//current month
	@Query(value = "SELECT * FROM booking_request WHERE MONTH(date) = MONTH(NOW()) ORDER BY date ASC", nativeQuery = true)
	public Iterable<Booking> thisMonthBookings();

	//current week
	@Query(value = "SELECT * FROM booking_request WHERE YEARWEEK(date) = YEARWEEK(NOW()) ORDER BY date ASC", nativeQuery = true)
	public Iterable<Booking> thisWeekBookings();


	//current day
	@Query(value = "SELECT * FROM booking_request WHERE DAY(date) = DAY(NOW())", nativeQuery = true)
	public Iterable<Booking> todayBookings();

	//bookings on a specific day
	@Query(value = "SELECT * FROM booking_request WHERE DAY(date) = DAY(:pickedDay)", nativeQuery = true)
	public Iterable<Booking> dayPickerBookings(@Param("pickedDay") LocalDate date);

	//bookings of specific mechanic on specific day
	@Query(value = "SELECT * FROM booking_request WHERE DAY(date) = DAY(:pickedDay) AND MECHANIC_ID = :mechanic", nativeQuery = true)
	public List<Booking> meckanicBookings(@Param("pickedDay") LocalDate date,@Param("mechanic")  Integer Id);

//	public Booking findByVehicle_id();
}
