package finalproject.Ger_garage.ServiceRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import finalproject.Ger_garage.UserDetails.UserRepository;
import finalproject.Ger_garage.Vehicle.Vehicle;
import finalproject.Ger_garage.Vehicle.VehicleRepository;

@RestController

@RequestMapping(path = "/request")
public class ServiceRequestController {
	@Autowired
	private ServiceRequestRepository serviceRequestRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@PostMapping("/add/{userId}")
	public String addRequest(@PathVariable Integer userId, @RequestBody ServiceRequest request) {
		userRepository.findById(userId).map(user -> {
			request.setUser(user);
			return serviceRequestRepository.save(request);

		});
		return "Saved";
	}

	@GetMapping("/requests")
	public Iterable<ServiceRequest> getRequests() {
		Iterable<Vehicle> vehicles = vehicleRepository.findAll();		
		return serviceRequestRepository.findAll();
	}
	

}
