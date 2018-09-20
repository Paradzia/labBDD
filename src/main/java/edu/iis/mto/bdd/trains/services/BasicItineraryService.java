package edu.iis.mto.bdd.trains.services;

import edu.iis.mto.bdd.trains.model.Line;
import org.joda.time.LocalTime;

import java.util.List;
import java.util.stream.Collectors;

public class BasicItineraryService implements ItineraryService {
    private TimetableService timetableService;

    public BasicItineraryService(InMemoryTimetableService inMemoryTimetableService) {
        this.timetableService = inMemoryTimetableService;
    }

    @Override public List<LocalTime> findDepartures(String departure, String destination, LocalTime departureTime) {
        Line line = timetableService.findLinesThrough(departure, destination).get(0);
        return timetableService.findArrivalTimes(line,departure).stream()
                .filter(time -> time.isAfter(departureTime) && time.isBefore(departureTime.plusMinutes(MAX_MINUTES_AFTER_DEPARTURE)))
                .collect(Collectors.toList());

    }
}
