package finalproject.Ger_garage.Controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import finalproject.Ger_garage.Models.User;
import finalproject.Ger_garage.Models.Vehicle;
import finalproject.Ger_garage.Repositories.UserRepository;
import finalproject.Ger_garage.Repositories.VehicleRepository;

@Controller
@RequestMapping("user")
public class VehicleController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private VehicleRepository vehicleRepository;

	/**
	 * Display all vehicle that user registered
	 * 
	 * @param model
	 * @param principal
	 * @return
	 */
	@GetMapping("vehicles")
	public String displayUsersVehicles(Model model, Principal principal) {
		// We have to find Vehicles that belong to the user who send a request
		User user = userRepository.findByEmail(principal.getName());

		// Then we send a vehicles with that user Id to the view
		model.addAttribute("userVehicles", vehicleRepository.findByUserId(user.getId()));
		return "user/user-vehicles";
	}

	/**
	 * Shows a form to add new vehicle
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("vehicle")
	public String displayVehicleForm(Model model) {
		model.addAttribute(new Vehicle());
		return "/user/vehicle-form";
	}

	/**
	 * adds new vehicle
	 * 
	 * @param vehicle
	 * @param errors
	 * @param principal
	 * @return
	 */
	@PostMapping("vehicle")
	public String addVehicle(@ModelAttribute @Valid Vehicle vehicle, Errors errors, Principal principal) {

		User user = userRepository.findByEmail(principal.getName());

		// if any errors, we reload the vehicle form page with displayed errors
		if (errors.hasErrors()) {
			return "user/vehicle-form";
		}
		vehicle.setUser(new User(user.getId(), null, null, null, null, null, null, null, null, null));
		vehicleRepository.save(vehicle);
		return "redirect:vehicles?success";
	}
	
	/**
	 * Delete Vehicle 
	 * @param id
	 * @return
	 */
	@PostMapping("vehicle/delete")
	public String deleteVehicle(@RequestParam Integer id) {
		vehicleRepository.deleteById(id);
		
		return "redirect:../vehicles?deleted";
	}

}
