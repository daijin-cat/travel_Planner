package test1;

import java.util.ArrayList;
import java.util.Date;

public class Trip {
    private String name;
    private Date startDate;
    private Date endDate;
    private ArrayList<Destination> destinations;

    public Trip(String name, Date startDate, Date endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        destinations = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    public ArrayList<Destination> getDestinations() {
        return destinations;
    }
}

