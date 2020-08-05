package finalproject.Ger_garage.Models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;



@Embeddable
@Table(name = "BOOKING_DATES")
public class BookingDate {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "Please choose a day")
    private LocalDate date;

    @Column(nullable = false)
//    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @DateTimeFormat(pattern = "HH:mm")
    @NotNull(message = "Please choose a time")
 private LocalTime  time;

    //  private boolean booked;

    public BookingDate() {
    }

    public BookingDate( @NotNull(message = "Please choose a day") LocalDate date, @NotNull(message = "Please choose a time") LocalTime time) {

        this.date = date;
        this.time = time;

    }



    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

}
