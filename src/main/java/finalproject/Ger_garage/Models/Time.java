package finalproject.Ger_garage.Models;


import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

@Service
public class Time {

    Collection<LocalTime> availableTime;

    public Time(Collection<LocalTime> availableTime) {
        this.availableTime = availableTime;

        availableTime.add( LocalTime.of(9, 0));
        availableTime.add( LocalTime.of(11, 0));
        availableTime.add( LocalTime.of(14, 0));
        availableTime.add( LocalTime.of(16, 0));
    }

    public Collection<LocalTime> getAvailableTime() {
        return availableTime;
    }

    public void setAvailableTime(Collection<LocalTime> availableTime) {
        this.availableTime = availableTime;
    }
}
