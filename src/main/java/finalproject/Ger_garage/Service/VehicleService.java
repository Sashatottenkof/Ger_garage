package finalproject.Ger_garage.Service;

import finalproject.Ger_garage.Models.User;
import finalproject.Ger_garage.Models.Vehicle;
import finalproject.Ger_garage.Repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;


    public Collection<Vehicle> findByUser(User user){return vehicleRepository.findByUser(user);};

    public void deleteVehicleById(Integer id){vehicleRepository.deleteById(id);};

    public void saveVehicle(Vehicle vehicle){vehicleRepository.save(vehicle);};
}
