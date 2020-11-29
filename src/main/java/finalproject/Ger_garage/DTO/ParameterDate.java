package finalproject.Ger_garage.DTO;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;


import java.time.LocalDate;

@Component
public class ParameterDate {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate date;

    public ParameterDate() {
    }

    public ParameterDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
