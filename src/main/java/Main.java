import Services.FlightFilterService;
import filters.Impl.DepartingInPast;
import filters.Impl.DepartsBeforeArrives;
import filters.Impl.GeneralCheck;
import filters.Impl.MoreThanTwoHoursGroundTime;
import flights.Flight;
import flights.FlightBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        FlightFilterService filterService = new FlightFilterService(new GeneralCheck(new DepartingInPast(), new DepartsBeforeArrives(), new MoreThanTwoHoursGroundTime()));

        List<Flight> flights = filterService.getValidFlights(FlightBuilder.createFlights());

        if (flights.isEmpty())
            System.out.println("no valid flight");
        else {
            for (Flight f : flights) {
                System.out.println(f.toString());
            }
        }
    }
}
