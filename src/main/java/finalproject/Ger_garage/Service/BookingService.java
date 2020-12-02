package finalproject.Ger_garage.Service;

import finalproject.Ger_garage.Models.Booking;
import finalproject.Ger_garage.Models.User;
import finalproject.Ger_garage.Repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private MechanicService mechanicService;


    public Iterable <Booking> findAll(){return bookingRepository.findAll();}

    public Booking findById(Integer id){return bookingRepository.findById(id).orElse(null);}

    public Collection <Booking> findByUser(User user){return bookingRepository.findByUser(user);}

    /**
     * Find if the booking already exists
     * @param booking
     * @return
     */
    public Booking findExistingBooking (Booking booking){

        LocalDate userDate = booking.getBookingDate().getDate();
        LocalTime userTime = booking.getBookingDate().getTime();

       return bookingRepository.findByDateAndTime(userDate,userTime);

    }

    public void save(Booking booking){bookingRepository.save(booking);}

    public Iterable <Booking> findThisMonthBookings(){return bookingRepository.thisMonthBookings();}
    public Iterable <Booking> findThisWeekBookings(){return bookingRepository.thisWeekBookings();}
    public Iterable <Booking> findTodayBookings(){return bookingRepository.todayBookings();}
    public Iterable <Booking> findBookingsOnSpecificDay(LocalDate date){return bookingRepository.dayPickerBookings(date);}
    public List<Booking> findBookingsForMechanicOnSpecificDay(LocalDate date, Integer id){return bookingRepository.mechanicBookings(date, id);}


}
