package finalproject.Ger_garage.Controllers;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import javax.validation.Valid;

import finalproject.Ger_garage.DeafultData.CalendarData;
import finalproject.Ger_garage.Enums.ServiceType;
import finalproject.Ger_garage.Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import finalproject.Ger_garage.Enums.BookingStatus;
import finalproject.Ger_garage.Repositories.BookingRepository;
import finalproject.Ger_garage.Repositories.UserRepository;
import finalproject.Ger_garage.Repositories.VehicleRepository;

// "principal" is a current logged in user

@Controller
@RequestMapping("user")
public class BookingUserController {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
//    @Autowired
//    private CalendarData calendarData;
    @Autowired
    private Time time;


    /**
     * display all user's bookings
     *
     * @param model
     * @param principal
     * @return
     */
    @GetMapping("bookings")
    public String displayUserBookings(Model model, Principal principal) {

        User user = userRepository.findByEmail(principal.getName());
        model.addAttribute("userBookings", bookingRepository.findByUserId(user.getId()));

                return "user/user-bookings";
    }

    /**
     * Displays booking form
     *
     * @param model
     * @return
     */
    @GetMapping("book")
    public String displayBookingForm(Model model, Principal principal) {

        User user = userRepository.findByEmail(principal.getName());
        model.addAttribute("booking", new Booking());
        model.addAttribute("userVehicles", vehicleRepository.findByUserId(user.getId()));
        model.addAttribute("availableTime", time.getAvailableTime());
        return "user/booking-form";
    }

    /**
     * To make a booking
     *
     * @param booking
     * @param principal
     * @return
     */
    @PostMapping("book")
    public String newBooking(@ModelAttribute("booking") @Valid Booking booking, Errors errors, Model model, Principal principal) {



        User user = userRepository.findByEmail(principal.getName());


        LocalDate userDate =  booking.getBookingDate().getDate();
        LocalTime userTime = booking.getBookingDate().getTime();

        Booking exestingDate = bookingRepository.findTopByBookingDateDate(userDate);

        Booking exestingDateTime= bookingRepository.findTopByBookingDateTime(userTime);


        if(exestingDateTime !=null &&  exestingDate !=null) {
            errors.pushNestedPath("bookingDate");
            errors.rejectValue("time",null, "That time has already been booked");
            errors.popNestedPath();
            model.addAttribute("userVehicles", vehicleRepository.findByUserId(user.getId()));
            model.addAttribute("availableTime", time.getAvailableTime());
            return "/user/booking-form";
        }

        if (errors.hasErrors()) {
            model.addAttribute("userVehicles", vehicleRepository.findByUserId(user.getId()));
            model.addAttribute("availableTime", time.getAvailableTime());
            return "/user/booking-form";
        }

        booking.setUser(new User(user.getId(), null, null, null, null,
                null, null, null, null, null, null, null));
        booking.setStatus(BookingStatus.BOOKED);
        booking.setPrice(booking.getType().getPrice());
 //       booking.setVehicle(new Vehicle(booking.getVehicleId(), null, null, null, null, null, null, null, null, null));
        bookingRepository.save(booking);

        return "redirect:bookings?success";
    }





//	@PostMapping("/add/{userId}")
//	public String addRequest(@PathVariable Integer userId, @RequestBody ServiceRequest request) {
//		userRepository.findById(userId).map(user -> {
//			request.setUser(user);
//			return serviceRequestRepository.save(request);
//
//		});
//		return "Saved";
//	}
//
//	@GetMapping("/requests")
//	public Iterable<ServiceRequest> getRequests() {
//		Iterable<Vehicle> vehicles = vehicleRepository.findAll();		
//		return serviceRequestRepository.findAll();
//	}
}
