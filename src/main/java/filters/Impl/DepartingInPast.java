package filters.Impl;

import filters.FlightCheckStrategy;
import flights.Flight;
import flights.Segment;

import java.time.LocalDateTime;

public class DepartingInPast implements FlightCheckStrategy {

    public DepartingInPast() {
    }

    @Override
    public boolean check(Flight flight) {
        for (Segment seg : flight.getSegments()) {
            if (seg.getDepartureDate().isBefore(LocalDateTime.now())) {
                return false;
            }
        }
        return true;
    }
}
