package edu.iis.mto.bdd.trains.cucumber.steps;

import cucumber.api.Transform;
import cucumber.api.java.pl.Gdy;
import cucumber.api.java.pl.Wtedy;
import cucumber.api.java.pl.Zakładając;
import edu.iis.mto.bdd.trains.model.Line;
import edu.iis.mto.bdd.trains.services.BasicItineraryService;
import edu.iis.mto.bdd.trains.services.InMemoryTimetableService;
import edu.iis.mto.bdd.trains.services.ItineraryService;
import org.joda.time.LocalTime;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class OptimalItinerarySteps {

    private String departureStation;
    private String destinationStation;
    private LocalTime startTime;
    private ItineraryService itineraryService;

    @Zakładając("^pociągi linii \"(.*)\" z \"(.*)\" odjeżdżają ze stacji \"(.*)\" do \"(.*)\" o$")
    public void givenArrivingTrains(String line, String lineStart, String departure, String destination,
            @Transform(JodaLocalTimeConverter.class) List<LocalTime> departureTimes) {
        this.departureStation = departure;
        this.destinationStation = destination;

        Line givenLine = new Line.LineBuilder(line).departingFrom(departureStation).withStations(destinationStation);
        InMemoryTimetableService inMemoryTimetableService = new InMemoryTimetableService();
        itineraryService = new BasicItineraryService(new InMemoryTimetableService());

    }

    @Gdy("^chcę podróżować z \"([^\"]*)\" do \"([^\"]*)\" o (.*)$")
    public void whenIWantToTravel(String departure, String destination,
            @Transform(JodaLocalTimeConverter.class) LocalTime startTime) {
        this.startTime = startTime;
    }

    @Wtedy("^powinienem uzyskać informację o pociągach o:$")
    public void shouldBeInformedAbout(@Transform(JodaLocalTimeConverter.class) List<LocalTime> expectedTrainTimes) {
        assertThat(itineraryService.findDepartures(departureStation, destinationStation, startTime), is(expectedTrainTimes));
    }
}
