package finalproject.Ger_garage.Repositories;


import finalproject.Ger_garage.Models.Calendar;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;


public interface CalendarRepository extends CrudRepository<Calendar, Integer> {
 //   public List<LocalDate> getAllDates(LocalDate startDate, LocalDate endDate);

// public List <LocalDate> findAll();
}