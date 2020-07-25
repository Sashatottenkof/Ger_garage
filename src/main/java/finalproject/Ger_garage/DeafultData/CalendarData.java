package finalproject.Ger_garage.DeafultData;

import finalproject.Ger_garage.Models.Calendar;
import finalproject.Ger_garage.Repositories.CalendarRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

@Component
public class CalendarData {

@Autowired
CalendarRepository calendarRepository;


    LocalDate startDate = LocalDate.of(2020, 6, 1);
    LocalDate endDate= LocalDate.of(2021, 6, 1);
    List <LocalDate> days;


    public CalendarData(CalendarRepository calendarRepository,  List<LocalDate> days) {
        this.calendarRepository = calendarRepository;
        this.days = days;

    }

    /**
     * Saves the dates in database
     */
@Bean
    public void populateCalendar(){

// we add dates into database only if it is empty
       Iterable<Calendar> test = calendarRepository.findAll();

        if (StreamSupport.stream(test.spliterator(), false).count() == 0) {
            days = getAllDates();
            for (LocalDate day :
                    days) {
                Calendar calendar = new Calendar();
                calendar.setDate(day);
                calendar.setStatus("Available");
                calendarRepository.save(calendar);
            }
        }

    }

    /**
     * Creates a list of dates
     * @return
     */

    public  List<LocalDate> getAllDates(
           ) {

        long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        return IntStream.iterate(0, i -> i + 1)
                .limit(numOfDaysBetween)
                .mapToObj(i -> startDate.plusDays(i))
                .collect(Collectors.toList());
    }




}