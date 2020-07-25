package finalproject.Ger_garage.Models;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;


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
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
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
//    public Optional<ValidationError> validate(LocalDate now) {
//        if (bookingDate == null) {
//            return Optional.of(new ValidationError("checkInDate.missing", "Missing check in date"));
//        } else if (bookingDate == null) {
//            return Optional.of(new ValidationError("checkOutDate.missing", "Missing check out date"));
//        } else if (bookingDate.isBefore(now)) {
//            return Optional.of(new ValidationError("checkInDate.future", "Check in date must be in the future"));
//        } else if (bookingDate.getDayOfWeek() == DayOfWeek.SUNDAY); {
//            return Optional.of(new ValidationError("checkOutDate.afterCheckIn", "Check out date must occur after check in date"));
//        } else if (totalNights() < 1) {
//            // handles case where check in/out dates are the same.
//            return Optional.of(new ValidationError("checkOutDate.minNights", "Reservation must be for at least 1 night"));
//        }
//        return Optional.empty();
//    }
//    public static class ValidationError {
//        private String code;
//        private String reason;
//
//        public ValidationError(String code, String reason) {
//            this.code = code;
//            this.reason = reason;
//        }
//
//        public String getCode() {
//            return code;
//        }
//
//        public String getReason() {
//            return reason;
//        }
//    }
}
