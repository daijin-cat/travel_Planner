package test1;

import java.util.ArrayList;

public class TravelPlanner {
    private ArrayList<Trip> trips;
    private ArrayList<Destination> destinations;

    public TravelPlanner() {
        trips = new ArrayList<>();
        destinations = new ArrayList<>();
    }

    public void addTrip(Trip trip) {
        trips.add(trip);
    }

    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    public ArrayList<Trip> getTrips() {
        return trips;
    }

    public ArrayList<Destination> getDestinations() {
        return destinations;
    }
}

