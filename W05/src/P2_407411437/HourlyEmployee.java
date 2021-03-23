package P2_407411437;

public class HourlyEmployee extends Employee {

	private int hours;
	private int hourlyPay;
	
	public HourlyEmployee(String name, String id, int empID, String title, int hours, int hourlyPay) {
		super(name, id, empID, title);
		this.hours = hours;
		this.hourlyPay = hourlyPay;
	}
	
	public HourlyEmployee() {
		
	}
	
	public int yearEarning() {
		
		return hourlyPay * hours;
	}

	public String toString() {
		return String.format("Name: %s\n" + 
				"ID: %s\n" + 
				"EmpID: %d\n" + 
				"Title: %s\n" + 
				"Hourly Employee working %d hours with the rate of %d dollars per hour.\r\n" 
				 , name , id, empID, title, hours, hourlyPay);
	}
}
