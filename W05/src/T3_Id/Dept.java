package T3_Id;

public class Dept extends Employee{

	private String DeptName;
	
	public Dept(String name, String phone, int salary, String DeptName) {
		super(name, phone, salary);
		this.DeptName = DeptName;
	}

	public Dept(String name, String phone, int salary) {
		super(name, phone, salary);
	}
	
	public String getDeptName() {
		return DeptName;
	}

	public void setDeptName(String deptName) {
		DeptName = deptName;
	}
	
}
