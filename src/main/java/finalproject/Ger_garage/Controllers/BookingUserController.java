package finalproject.Ger_garage.Controllers;

import java.security.Principal;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.apache.tomcat.jni.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import finalproject.Ger_garage.Enums.BookingStatus;
import finalproject.Ger_garage.Models.Booking;
import finalproject.Ger_garage.Models.User;
import finalproject.Ger_garage.Models.Vehicle;
import finalproject.Ger_garage.Repositories.BookingRepository;
import finalproject.Ger_garage.Repositories.UserRepository;
import finalproject.Ger_garage.Repositories.VehicleRepository;


@Controller
@RequestMapping("user")
public class BookingUserController {
	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private VehicleRepository vehicleRepository;
	
	

	/**
	 * display all user's bookings
	 * @param model
	 * @param principal
	 * @return
	 */
	@GetMapping("bookings")
	public String displayUserBookings(Model model, Principal principal) {
		User user = userRepository.findByEmail(principal.getName());

		model.addAttribute("userBookings",  bookingRepository.findByUserId(user.getId()));

		return "user/user-bookings";
	}
	
		/**
	 * Displays booking form
	 * @param model
	 * @return
	 */
	@GetMapping("book")
	public String displayBookingForm(Model model, Principal principal) {
//		Set<String> vehicles;
		User user = userRepository.findByEmail(principal.getName());
//		Vehicle vehicle = vehicleRepository.findByUserId(user.getId());
//		Collection<Vehicle> vehicleCollection = vehicleRepository.findByUserId(user.getId());
//		Map<String,Integer> vehicleMap = new HashMap<String,Integer>();
//		if( vehicleCollection != null && !vehicleCollection.isEmpty()){
//		     for(Vehicle eachVehicle : vehicleCollection ){
//		         if(eachVehicle != null){
//		        	 vehicleMap.put(eachVehicle.getModel(), eachVehicle.getVehicle_id());
//		        }
//		     }
//		  }
		model.addAttribute("booking",new Booking());
//		model.addAttribute("vehicle", vehicle);
//		vehicles = vehicleMap.keySet(); 
//		model.addAttribute("vehicle",new Vehicle());
//		model.addAttribute("userVehicle", vehicleRepository.findByUserId(user.getId()));
		model.addAttribute("userVehicles", vehicleRepository.findByUserId(user.getId()));
		return "user/booking-form";
	}

	/**
	 * To make a booking
	 * @param booking
	 * @param
	 * @param
	 * @param principal
	 * @return
	 */
	@PostMapping("book")
	public String newBooking(@ModelAttribute("booking") @Valid Booking booking, Errors errors,  Model model, Principal principal) {


		
//		Vehicle vehicle = booking.getVehicle();
//
//
//		Vehicle newVehicle = new Vehicle(vehicle.getVehicle_id(), null, null, null, null, null, null, null, null, null);
//		booking.setVehicle(newVehicle);
		
//		Collection<Integer> vehicles;
//		User user = userRepository.findByEmail(principal.getName());
//		Collection<Vehicle> vehicleCollection = vehicleRepository.findByUserId(user.getId());
//		Map<String,Integer> vehicleMap = new HashMap<String,Integer>();
//		if( vehicleCollection != null && !vehicleCollection.isEmpty()){
//		     for(Vehicle eachVehicle : vehicleCollection ){
//		         if(eachVehicle != null){
//		        	 vehicleMap.put(eachVehicle.getModel(), eachVehicle.getVehicle_id());
//		        }
//		     }
//		  }
//		
//		vehicles = vehicleMap.values(); 
		
		User user = userRepository.findByEmail(principal.getName());

//		Optional<Vehicle> vehicle =  vehicleRepository.findById(booking.getVehicle().getVehicle_id());
		
		
		
//	    if(errors.hasErrors()) {
//			return "/user/booking-form";
//		}
		booking.setUser(new User(user.getId(), null, null, null, null, null, null, null, null, null, null, null));
		booking.setStatus( BookingStatus.BOOKED);
		

		
       booking.setVehicle(new Vehicle (booking.getVehicleId(), null, null, null, null, null, null, null, null, null));
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
