package finalproject.Ger_garage.Vehicle;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import finalproject.Ger_garage.UserDetails.UserRepository;
import javassist.NotFoundException;

@RestController

@RequestMapping(path = "/user")
public class VehicleController {
	@Autowired
	VehicleRepository vehicleRepository;
	@Autowired
	UserRepository userRepository;

	// @ResponseBody means the returned String is the response, not a view name
	// @RequestParam means it is a parameter from the GET or POST request
	@PostMapping("/{userId}/vehicles")
	public String addVehicle(@PathVariable Integer userId, @RequestBody Vehicle vehicle) {
		userRepository.findById(userId).map(user -> {
			vehicle.setUser(user);
			return vehicleRepository.save(vehicle);

		});
		return "Saved";
	}

	@GetMapping("/vehicles")
	public Iterable<Vehicle> getVehicles() {
		return vehicleRepository.findAll();
	}

	@GetMapping("/vehicle/{id}")
	public Vehicle getUser(@PathVariable Integer id) throws NotFoundException {
		Optional<Vehicle> vehicle = vehicleRepository.findById(id);
		if (vehicle.isPresent()) {
			return vehicle.get();
		} else {
			throw new NotFoundException("Vehicle not found with id " + id);
		}
	}
//	@PutMapping("/vehicle/{id}")
//	public String updateUser(@PathVariable Integer id) {
//		vehicleRepository.deleteById(id);
//		return "Deleted";
//	}

	@DeleteMapping("/vehicle/{id}")
	public String deleteUser(@PathVariable Integer id) {
		vehicleRepository.deleteById(id);
		return "Deleted";
	}

}
