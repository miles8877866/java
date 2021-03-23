package T3_Id;

public class TA extends Dept {

	private String course;
	private String grad;

	public TA(String Name, String Phone, int Salary, String DeptName) {
		super(Name, Phone, Salary, DeptName);
	}

	public TA(String Name, String Phone, int Salary) {
		super(Name, Phone, Salary);
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String toString() {
		return String.format("%s: Teaching Assistant, %s program of Computer Science.\n" + "==> Course: %s\n"
				+ "==> Salary: %d,  Phone#: %s\n", Name, getGrad(), getCourse(), getSalary(), getPhone());
	}
}
