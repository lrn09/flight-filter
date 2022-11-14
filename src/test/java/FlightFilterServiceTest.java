import Services.FlightFilterService;
import filters.Impl.DepartingInPast;
import filters.Impl.DepartsBeforeArrives;
import filters.Impl.GeneralCheck;
import filters.Impl.MoreThanTwoHoursGroundTime;
import flights.Flight;
import flights.FlightBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FlightFilterServiceTest {

    FlightFilterService sut;

    @Before
    public void init() {
        sut = new FlightFilterService(new GeneralCheck(
                new DepartingInPast(),
                new DepartsBeforeArrives(),
                new MoreThanTwoHoursGroundTime()));

    }

    @Test
    public void testValidFlights() {
        //arrange
        List<Flight> flights = FlightBuilder.createFlights();
        List<Flight> validFlights = new ArrayList<>(flights.subList(0, 2));

        //assert
        Assert.assertEquals(validFlights, sut.getValidFlights(flights));

    }

    @Test
    public void testNoValidFlights() {
        //arrange
        List<Flight> flights = FlightBuilder.createFlights();
        List<Flight> expectedFlights = new ArrayList<>();
        List<Flight> badFlights = new ArrayList<>(flights.subList(2, flights.size() - 1));

        //assert
        Assert.assertEquals(expectedFlights, sut.getValidFlights(badFlights));

    }
}
