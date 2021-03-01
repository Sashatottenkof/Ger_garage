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


    public Collection<Vehicle> findByUser(User user) {
        return vehicleRepository.findByUser(user);
    }

    /**
     * delete Vehicle
     * @param id
     * @return
     */
    public boolean deleteVehicleById(Integer id) {
        try {
            vehicleRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    public void saveVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }


    public Vehicle findVehicleById(Integer id) {
        return vehicleRepository.findById(id).get();
    }

    /**
     * Update Vehicle
     * @param update
     */

    public void update(Vehicle update) {

        Vehicle originalVehicle = findVehicleById(update.getVehicle_id());

        originalVehicle.setAge(update.getAge());
        originalVehicle.setEngine(update.getEngine());
        originalVehicle.setLicence(update.getLicence());
        originalVehicle.setMake(update.getMake());
        originalVehicle.setMileage(update.getMileage());
        originalVehicle.setModel(update.getModel());
        originalVehicle.setOther_details(update.getOther_details());

        saveVehicle(originalVehicle);

    }
}
