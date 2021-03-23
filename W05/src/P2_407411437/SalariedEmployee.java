package P2_407411437;

public class SalariedEmployee extends Employee {

	private int salary;
	
	public SalariedEmployee(String Name, String ID, int EmpID, String Title, int Salary) {
		super(Name, ID, EmpID, Title);
		this.salary = Salary;
	}

	public SalariedEmployee() {
		
	}

	public void setSalary(int Salary) {
		
		this.salary = Salary;
	}

	public int yearEarning() {
		
		return salary * 12;
	}
	
	public String toString() {
		return String.format("Name: %s\n" + 
				"ID: %s\n" + 
				"EmpID: %d\n" + 
				"Title: %s\n" + 
				"Salaried Employee with salary %d per month.\n" 
				, name, id, empID, title, salary);
	}

}
