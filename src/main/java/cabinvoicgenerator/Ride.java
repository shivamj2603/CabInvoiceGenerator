package cabinvoicgenerator;

public class Ride {
	public int userId;
	public double distance;
	public int time;
	public String typeOfRide;
	public Ride(int userId, double distance , int time, String typeOfRide) {
		this.userId = userId;
		this.distance = distance;
		this.time = time;
		this.typeOfRide = typeOfRide;
	}
}
