package Services;

import filters.Impl.GeneralCheck;
import flights.Flight;

import java.util.ArrayList;
import java.util.List;

public class FlightFilterService {

    GeneralCheck generalCheck;

    public FlightFilterService(GeneralCheck generalCheck) {
        this.generalCheck = generalCheck;
    }

    public List<Flight> getValidFlights(List<Flight> flights) {
        List<Flight> validFlights = new ArrayList<>();

        for (Flight f : flights) {
            if (generalCheck.check(f))
                validFlights.add(f);
        }
        return validFlights;
    }

}