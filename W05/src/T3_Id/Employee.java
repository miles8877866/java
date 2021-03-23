package T3_Id;

public class Employee {

	protected String Name;
	protected String Phone;
	protected int Salary;
	
	public Employee() {
		
	}
	
	public Employee (String name, String phone, int salary) {
		this.Name = name;
		this.Phone = phone;
		this.Salary = salary;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public int getSalary() {
		return Salary;
	}

	public void setSalary(int salary) {
		Salary = salary;
	}

}
