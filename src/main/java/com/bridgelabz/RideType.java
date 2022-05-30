package com.bridgelabz;

public class RideType {
	private static final double MINIMUN_COST_PER_KM = 10.0;
	private static final int COST_PER_TIME = 1;
	private static final double MINIMUN_FARE = 5;

	private static final double MINIMUN_COST_PER_KM_PRE = 15.0;
	private static final int COST_PER_TIME_PER = 2;
	private static final double MINIMUN_FARE_PER = 20;

	public static double CalculateFareNormal(double distance, int time) {
		double totalFare = distance * MINIMUN_COST_PER_KM + time * COST_PER_TIME;
		return Math.max(totalFare, MINIMUN_FARE);
	}

	public static double CalculateFarePER(double distance, int time) {
		double totalFare = distance * MINIMUN_COST_PER_KM_PRE + time * COST_PER_TIME_PER;
		return Math.max(totalFare, MINIMUN_FARE_PER);
	}
	public InvoiceSummary CalculateFare(Rides[] rides) {
		double totalFare = 0.0;
		for (Rides ride : rides) {
			totalFare += this.CalculateFare(ride.distance , ride.time);
		}
		return new InvoiceSummary(rides.length,totalFare);
	}
	public double CalculateFare(double distance, int time) {
		double totalFare = distance * MINIMUN_COST_PER_KM + time * COST_PER_TIME;
		return Math.max(totalFare, MINIMUN_FARE);
	}
}
