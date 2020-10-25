package cabinvoicgenerator;

public class InvoiceSummary {
	private double average;
	private double totalfare;
	private int numOfRides;
		public InvoiceSummary(int numOfRides, double totalFare) {
		this.numOfRides = numOfRides;
		this.totalfare = totalFare;
		this.average = numOfRides / totalFare;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceSummary other = (InvoiceSummary) obj;
		if (Double.doubleToLongBits(average) != Double.doubleToLongBits(other.average))
			return false;
		if (numOfRides != other.numOfRides)
			return false;
		if (Double.doubleToLongBits(totalfare) != Double.doubleToLongBits(other.totalfare))
			return false;
		return true;
	}
}
