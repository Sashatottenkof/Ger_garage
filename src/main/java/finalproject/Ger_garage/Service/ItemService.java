package finalproject.Ger_garage.Service;

import finalproject.Ger_garage.Models.Booking;
import finalproject.Ger_garage.Models.Item;
import finalproject.Ger_garage.Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private BookingService bookingService;

    public Iterable<Item> findAll(){return itemRepository.findAll();}
    public Item findById(Integer id){return itemRepository.findById(id).get();}
    /**
     * Add item
     * @param bookingId
     * @param itemId
     */

    public void addItem(Integer bookingId, Integer itemId) {
        Booking booking = bookingService.findById(bookingId);
        Item item = findById(itemId);
        booking.getItems().add(item);
        //alter the price every time new item added
        booking.setPrice(booking.getPrice() + item.getPrice());
        bookingService.save(booking);
    }

    /**
     * Delete item
     * @param bookingId
     * @param itemId
     */
    public  void deleteItem(Integer bookingId, Integer itemId)
    {
        Booking booking = bookingService.findById(bookingId);
        Item item =findById(itemId);
        booking.getItems().remove(item);
        //alter the price every time new item added
        booking.setPrice(booking.getPrice() - item.getPrice());
        bookingService.save(booking);
    }
}
