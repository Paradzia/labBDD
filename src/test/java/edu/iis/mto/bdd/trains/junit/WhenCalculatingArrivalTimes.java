package edu.iis.mto.bdd.trains.junit;

import edu.iis.mto.bdd.trains.model.Line;
import edu.iis.mto.bdd.trains.services.BasicItineraryService;
import edu.iis.mto.bdd.trains.services.InMemoryTimetableService;
import edu.iis.mto.bdd.trains.services.ItineraryService;
import edu.iis.mto.bdd.trains.services.TimetableService;
import org.joda.time.LocalTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;

public class WhenCalculatingArrivalTimes {
    private ItineraryService itineraryService;
    private TimetableService timetableService;

    private Line line = new Line.LineBuilder("linia").departingFrom("here").withStations("here", "there", "somewhere");
    List<LocalTime> times = Arrays.asList(new LocalTime(7,40), new LocalTime(8, 10),
            new LocalTime(8, 20), new LocalTime(8, 30), new LocalTime(8, 40));


    @Before
    public void setUp(){
        timetableService = mock(InMemoryTimetableService.class);
        itineraryService = new BasicItineraryService(timetableService);
        Mockito.when(timetableService.findLinesThrough(anyString(), anyString())).thenReturn(Arrays.asList(line));
    }

    @Test
    public void findDeparturesShouldReturnListOfLocalTimes() {
        assertThat(itineraryService.findDepartures("Start", "Destination", times.get(0)),
                isA(List.class));
        assertThat(itineraryService.findDepartures("Start", "Destination", times.get(0)),
                everyItem(isA(LocalTime.class)));
    }
    @Test
    public void findDeparturesShouldReturnCorrectTimeValues() {
        Mockito.when(timetableService.findArrivalTimes(eq(line), anyString())).thenReturn(times);
        assertThat(itineraryService.findDepartures("Start", "Destination", times.get(0)),
                empty());
    }
    @Test
    public void findDeparturesShouldReturnOnlyTimeValuesAfterDepartureTime() {
        Mockito.when(timetableService.findArrivalTimes(eq(line), anyString())).thenReturn(times);
        assertThat(itineraryService.findDepartures("Start", "Destination", new LocalTime(6,50)),
                not(hasItem(times.get(0))));
    }
    @Test
    public void findDeparturesShouldNotReturnValuesAfterSpecificTimeFrame() {
        Mockito.when(timetableService.findArrivalTimes(eq(line), anyString())).thenReturn(times);
        LocalTime departure = new LocalTime(6, 50);
        assertThat(itineraryService.findDepartures("Start", "Destination", departure),
                not(hasItem(greaterThan(departure.plusMinutes(ItineraryService.MAX_MINUTES_AFTER_DEPARTURE)))));
    }

}
