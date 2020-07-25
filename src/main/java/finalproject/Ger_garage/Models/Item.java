package finalproject.Ger_garage.Models;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String name;
    double price;
//    @ManyToMany(mappedBy = "items")
//    @Fetch(value = FetchMode.SUBSELECT)
//    private Collection<Booking> bookings = new ArrayList<>();


    public Item() {
    }

    public Item(Integer id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
