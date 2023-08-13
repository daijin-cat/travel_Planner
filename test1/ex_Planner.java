package test1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ex_Planner {
    private static final TravelPlanner travelPlanner = new TravelPlanner();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("1. 여행 일정 추가");
                System.out.println("2. 여행지 추가");
                System.out.println("3. 여행 일정 조회");
                System.out.println("4. 여행지 조회");
                System.out.println("5. 종료");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addTrip(scanner);
                        break;
                    case 2:
                        addDestination(scanner);
                        break;
                    case 3:
                        showTrips();
                        break;
                    case 4:
                        showDestinations();
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("잘못된 입력입니다.");
                        break;
                }
            }
        }
    }

    private static void addTrip(Scanner scanner) {
        System.out.print("여행 일정 이름: ");
        String name = scanner.nextLine();

        System.out.print("여행 시작일(yyyy-MM-dd): ");
        Date startDate = parseDate(scanner.nextLine());

        System.out.print("여행 종료일(yyyy-MM-dd): ");
        Date endDate = parseDate(scanner.nextLine());

        Trip trip = new Trip(name, startDate, endDate);
        travelPlanner.addTrip(trip);

        System.out.println("여행 일정이 추가되었습니다.");
    }

    private static void addDestination(Scanner scanner) {
        System.out.print("여행지 이름: ");
        String name = scanner.nextLine();

        System.out.print("여행지 설명: ");
        String description = scanner.nextLine();

        Destination destination = new Destination(name, description);
        travelPlanner.addDestination(destination);

        System.out.println("여행지가 추가되었습니다.");
    }

    private static void showTrips() {
        ArrayList<Trip> trips = travelPlanner.getTrips();

        if (trips.isEmpty()) {
            System.out.println("등록된 여행 일정이 없습니다.");
            return;
        }

        for (Trip trip : trips) {
            System.out.println("여행 일정 이름: " + trip.getName());
            System.out.println("여행 기간: " + dateFormat.format(trip.getStartDate()) + " ~ " + dateFormat.format(trip.getEndDate()));

            ArrayList<Destination> destinations = trip.getDestinations();

            if (destinations.isEmpty()) {
                System.out.println("등록된 여행지가 없습니다.");
            } else {
                System.out.println("등록된 여행지:");

                for (Destination destination : destinations) {
                    System.out.println("- " + destination.getName() + ": " + destination.getDescription());
                }
            }

            System.out.println();
        }
    }

    private static void showDestinations() {
        ArrayList<Destination> destinations = travelPlanner.getDestinations();

        if (destinations.isEmpty()) {
            System.out.println("등록된 여행지가 없습니다.");
            return;
        }

        for (Destination destination : destinations) {
            System.out.println("여행지 이름: " + destination.getName());
            System.out.println("여행지 설명: " + destination.getDescription());
            System.out.println();
        }
    }

    private static Date parseDate(String dateString) {
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("잘못된 날짜 형식입니다. (yyyy-MM-dd)");
            return null;
        }
    }
}