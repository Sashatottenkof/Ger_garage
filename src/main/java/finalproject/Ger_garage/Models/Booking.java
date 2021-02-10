package finalproject.Ger_garage.Models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.core.SpringVersion;
import org.springframework.format.annotation.DateTimeFormat;

import finalproject.Ger_garage.Enums.BookingStatus;

import finalproject.Ger_garage.Enums.ServiceType;

@Entity
@Table(name = "BOOKING_REQUEST")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ServiceType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookingStatus status;


    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "VEHICLE_ID", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "MECHANIC_ID")
    private Mechanic mechanic;

//    @Temporal(TemporalType.DATE)
//@Column(nullable = false)
////    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
//@DateTimeFormat( pattern="yyyy-MM-dd [HH:mm]")
//private LocalDateTime dateTime;
//@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//    private LocalDate dateTime;
    @Embedded
    @Valid
    //@NotNull(message = "Choose your day of service")
    private BookingDate bookingDate;

    @Lob
    private String comment;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(
            name = "items",
            joinColumns = @JoinColumn(
                    name = "booking_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "item_id", referencedColumnName = "id"))
    private Collection<Item> items = new ArrayList<>();

     private double price;



    public Booking() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Booking(Integer id, ServiceType type, BookingStatus status, User user, Vehicle vehicle, Mechanic mechanic, BookingDate bookingDate, String comment, Collection<Item> items, double price) {
        this.id = id;
        this.type = type;
        this.status = status;
        this.user = user;
        this.vehicle = vehicle;
        this.mechanic = mechanic;
        this.bookingDate = bookingDate;
        this.comment = comment;
        this.items = items;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ServiceType getType() {
        return type;
    }

    public void setType(ServiceType type) {
        this.type = type;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    public BookingDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(BookingDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getDate(){return getBookingDate().getDate();};
    public LocalTime getTime(){return getBookingDate().getTime();};

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}