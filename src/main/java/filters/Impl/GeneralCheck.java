package filters.Impl;

import filters.FlightCheckStrategy;
import flights.Flight;

import java.util.ArrayList;
import java.util.List;

public class GeneralCheck implements FlightCheckStrategy {

    List<FlightCheckStrategy> flightCheckStrategyList = new ArrayList<>();

    public GeneralCheck(FlightCheckStrategy... flightCheckStrategy) {
        flightCheckStrategyList.addAll(List.of(flightCheckStrategy));
    }

    @Override
    public boolean check(Flight flight) {
        for (FlightCheckStrategy f : flightCheckStrategyList) {
            if (!f.check(flight))
                return false;
        }
        return true;
    }
}
