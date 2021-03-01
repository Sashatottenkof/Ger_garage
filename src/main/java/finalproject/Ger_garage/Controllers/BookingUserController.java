package finalproject.Ger_garage.Controllers;

import java.security.Principal;


import javax.validation.Valid;


import finalproject.Ger_garage.Models.*;
import finalproject.Ger_garage.Service.BookingService;
import finalproject.Ger_garage.Service.UserService;
import finalproject.Ger_garage.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import finalproject.Ger_garage.Enums.BookingStatus;

// "principal" is a current logged in user

@Controller
@RequestMapping("user")
public class BookingUserController {

    @Autowired
    private UserService userService;
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private BookingService bookingService;

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

        User user = userService.findByEmail(principal.getName());
        model.addAttribute("userBookings", bookingService.findByUser(user));

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


        User user = userService.findByEmail(principal.getName());
        model.addAttribute("booking", new Booking());
        model.addAttribute("userVehicles", vehicleService.findByUser(user));
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


        User user = userService.findByEmail(principal.getName());


        // find if that time is available
        Booking existingBooking = bookingService.findExistingBooking(booking);


        if (existingBooking != null) {
            errors.pushNestedPath("bookingDate");
            errors.rejectValue("time", null, "That time has already been booked");
            errors.popNestedPath();
        }

        if (errors.hasErrors()) {
            model.addAttribute("userVehicles", vehicleService.findByUser(user));
            model.addAttribute("availableTime", time.getAvailableTime());
            return "user/booking-form";
        }

        booking.setUser(new User(user.getId(), null, null, null, null,
                null, null, null, null));
        booking.setStatus(BookingStatus.BOOKED);
        booking.setPrice(booking.getType().getPrice());
        bookingService.save(booking);

        return "redirect:bookings?success";
    }

    /**
     * Delete Vehicle
     * @param id
     * @return
     */
    @PostMapping("booking/delete")
    public String deleteBooking(@RequestParam Integer id) {

        bookingService.deleteByBookingId(id);

        return "redirect:../bookings?deleted";
    }

    /**
     * Display page with receipt for specific booking
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("receipt/{id}")
    public String displayReceipt(@PathVariable Integer id, Model model) {

        model.addAttribute("booking", bookingService.findById(id));

        return "user/receipt";
    }


}
