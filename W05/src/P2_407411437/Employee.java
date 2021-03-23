package P2_407411437;

public abstract class Employee {

	protected String name;
	protected String id;
	protected int empID;
	protected String title;
	// protected int salary;

	public Employee() {
		
	}
	public Employee(String name, String ID, int empID, String title) {
		this.name = name;
		this.id =ID;
		this.empID = empID;
		this.title = title;
	}
	public void setName(String Name) {
		this.name = Name;
	}

	public void setId(String ID) {
		this.id = ID;
	}

	public void setEmpID(int EmpID) {
		this.empID = EmpID;
	}

	public void setTitle(String Title) {
		this.title = Title;
	}

	public abstract int yearEarning();
}
