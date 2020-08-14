package finalproject.Ger_garage.Controllers;

import finalproject.Ger_garage.DTO.ParameterDate;
import finalproject.Ger_garage.Models.*;
import finalproject.Ger_garage.Repositories.BookingRepository;
import finalproject.Ger_garage.Repositories.ItemRepository;
import finalproject.Ger_garage.Repositories.MechanicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import finalproject.Ger_garage.Repositories.UserRepository;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("admin")
public class AdminController {

	
	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepository;
	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private MechanicRepository mechanicRepository;
	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private ParameterDate parameterDate;
	/**
	 * Display all registered users
	 * @param model
	 * @return
	 */
	@GetMapping("users")
	public String  allUsers(Model model) {
		//model.addAttribute("name", "users");
		model.addAttribute("allUsers", userRepository.findAll());
		return "admin/users";
	}

	/**processed with "form"
	 * delete a user by id
	 * @param id
	 * @return
	 */
	@PostMapping("users")
	public String deleteUser(@RequestParam Integer id) {
		userRepository.deleteById(id);
		return "redirect:users";
	}


	/**
	 * Displays all bookings
	 * @param model
	 * @return
	 */
	@GetMapping("bookings")
	public String  allBookings(Model model) {
		model.addAttribute("bookings", bookingRepository.findAll());
		model.addAttribute("chosenDate", parameterDate);
		return "admin/bookings";
	}
	/**
	 * Diasplays bookings for current month
	 * @param model
	 * @return
	 */
	@GetMapping("thismonth-bookings")
	public String  monthBookings(Model model) {
		model.addAttribute("bookings", bookingRepository.thisMonthBookings());
		model.addAttribute("chosenDate", parameterDate);
		return "admin/bookings";
	}

	/**
	 * Diasplays bookings for current week
	 * @param model
	 * @return
	 */
	@GetMapping("thisweek-bookings")
	public String  weekBookings(Model model) {
		model.addAttribute("bookings", bookingRepository.thisWeekBookings());
		model.addAttribute("chosenDate", parameterDate);
		return "admin/bookings";
	}

	/**
	 * Diasplays bookings for today
	 * @param model
	 * @return
	 */
	@GetMapping("today-bookings")
	public String  todayBookings(Model model) {
		model.addAttribute("bookings", bookingRepository.todayBookings());
		model.addAttribute("chosenDate", parameterDate);
		return "admin/bookings";
	}


	/**
	 * Diasplays bookings for specific day
	 * @param model
	 * @return
	 */
	@PostMapping ("daypicker-bookings")
	public String  dayPickerBookings(@ModelAttribute("chosenDate") @Valid ParameterDate parameterDate, Errors errors, Model model) {

		if ( errors.hasErrors()) {
			errors.rejectValue("date",null, "You have to choose a day");
			return "admin/bookings";
		}

		LocalDate date = parameterDate.getDate();

		model.addAttribute("chosenDate", parameterDate);
		model.addAttribute("bookings", bookingRepository.dayPickerBookings(date));

		return "admin/bookings";
	}
	/**
	 * Display specific booking
	 * View can not render Optional format, we have to pars only Object
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("booking-details/{id}")
	public String  oneBooking(@PathVariable Integer id, Model model) {
		bookingRepository.findById(id).ifPresent(o -> model.addAttribute("booking", o));

		model.addAttribute("mechanics", mechanicRepository.findAll());
		model.addAttribute("items", itemRepository.findAll());

		return "admin/booking-details";
	}

	/**
	 * Updates booking by changing booking status, mechanic, and price
	 * @param booking
	 * @param errors
	 * @param model
	 * @return
	 */
	@PostMapping("update")
	public String updateBooking(@ModelAttribute("booking") @Valid Booking booking, Errors errors, Model model) {
		// We have to transfer items from old booking since thymeleaf form doesn't submit them
		Booking oldBooking = bookingRepository.findById(booking.getId()).get();
		Booking newBooking = booking;
		newBooking.setItems(oldBooking.getItems());


		// Validate that one machanic has no more then 4 bookings per day
		List<Booking> mechanicsBookings = bookingRepository.meckanicBookings(newBooking.getDate(), newBooking.getMechanic().getId());
		if(mechanicsBookings.size()>=4) {
			//we have to make sure that when an admin wants to make changes other than assigning mechanic,it won't cause the error
			if (oldBooking.getMechanic() != null) {
				//if the booking already has the same mechanic it will save the changes without any problem
				if(oldBooking.getMechanic().getId().equals(newBooking.getMechanic().getId())) {
					bookingRepository.save(newBooking);
					return "redirect:bookings?updated";
				}
			}
			errors.rejectValue("mechanic.id", null, "One mechanic can't do more than 4 services per day");
		}
		if(errors.hasErrors()) {
			model.addAttribute("mechanics", mechanicRepository.findAll());
			model.addAttribute("items", itemRepository.findAll());
			return "admin/booking-details";
		}

		bookingRepository.save(newBooking);
		return "redirect:bookings?updated";
	}

	/**
	 *  adding items to the booking with URL
	 * @param id
	 * @param itemId
	 * @return
	 */
	@GetMapping ("additem/{id}/{itemId}")
	public String addItems(@PathVariable Integer id, @PathVariable Integer itemId) {
		Booking booking = bookingRepository.findById(id).get();
        Item item = itemRepository.findById(itemId).get();
		booking.getItems().add(item);
		//alter the price every time new item added
		booking.setPrice( booking.getPrice() + item.getPrice());
		bookingRepository.save(booking);
		return "redirect:../../booking-details/{id}?added";
	}
	/**
	 * remove items to the booking with URL
	 * @param id
	 * @param itemId
	 * @return
	 */
	@GetMapping ("deleteitem/{id}/{itemId}")
	public String deleteItems(@PathVariable Integer id, @PathVariable Integer itemId) {
		Booking booking = bookingRepository.findById(id).get();
		Item item = itemRepository.findById(itemId).get();
		booking.getItems().remove(item);
		//alter the price every time new item added
		booking.setPrice( booking.getPrice() - item.getPrice());
		bookingRepository.save(booking);
		return "redirect:../../booking-details/{id}?deleted";
	}



	@GetMapping("calendar")
	public String  calendar(Model model) {
//		model.addAttribute("bookings", bookingRepository.findAll());

		return "admin/calendar";
	}

}
