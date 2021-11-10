public class InvoiceGenerator {
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_COST_PER_KILOMETER = 10;
    private static final int MINIMUM_FARE = 5;



    public static double calculateFare(double distance, int time){
        double totalDistance = distance * MINIMUM_COST_PER_KILOMETER  + time * COST_PER_TIME;
        return totalDistance < MINIMUM_FARE ? MINIMUM_FARE : totalDistance;
    }
    public static InvoiceSummary calculateFare(Ride[] rides){
        double totalFare = 0;
        for(Ride ride:rides) {
            totalFare += calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }
}
