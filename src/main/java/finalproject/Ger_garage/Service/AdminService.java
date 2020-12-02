package finalproject.Ger_garage.Service;

import finalproject.Ger_garage.DTO.ParameterDate;
import finalproject.Ger_garage.Models.Booking;
import finalproject.Ger_garage.Models.Item;
import finalproject.Ger_garage.Models.User;
import finalproject.Ger_garage.Repositories.BookingRepository;
import finalproject.Ger_garage.Repositories.ItemRepository;
import finalproject.Ger_garage.Repositories.MechanicRepository;
import finalproject.Ger_garage.Repositories.UserRepository;
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
