package finalproject.Ger_garage.Service;

import finalproject.Ger_garage.Models.Booking;
import finalproject.Ger_garage.Models.Mechanic;
import finalproject.Ger_garage.Repositories.BookingRepository;
import finalproject.Ger_garage.Repositories.MechanicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MechanicService {

    @Autowired
    private MechanicRepository mechanicRepository;
    @Autowired
    private BookingService bookingService;

    public Iterable<Mechanic> findAll() {
        return mechanicRepository.findAll();
    }

    /**
     * Check that number of bookings for one mechanic doesn't extend the limit (4)
     *
     * @param booking
     * @return
     */
    public Boolean tooManyBookings(Booking booking) {
        Integer id = booking.getMechanic().getId();
        LocalDate date = booking.getDate();

        List<Booking> mechanicsBookings = bookingService.findBookingsForMechanicOnSpecificDay(date, id);
        if (mechanicsBookings.size() >= 4) {
            return true;
        }
        else return false;
    }
}
