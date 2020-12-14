package finalproject.Ger_garage.Service;

import finalproject.Ger_garage.DTO.ParameterDate;
import finalproject.Ger_garage.Repositories.MechanicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private UserService userService;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private MechanicRepository mechanicRepository;
    @Autowired
    private ItemService itemService;

    @Autowired
    private ParameterDate parameterDate;


}
