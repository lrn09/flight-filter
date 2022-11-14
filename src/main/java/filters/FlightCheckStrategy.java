package filters;

import flights.Flight;

public interface FlightCheckStrategy {

    boolean check(Flight flight);
}
