package T3_Id;

public class Professor extends Dept {

	private String course;
	private String rank;

	public Professor(String Name, String Phone, int Salary, String DeptName) {
		super(Name, Phone, Salary, DeptName);
	}

	public Professor(String Name, String Phone, int Salary) {
		super(Name, Phone, Salary);
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String toString() {
		return String.format(
				"%s: %s Professor of Computer Science.\n" + "==> Course: %s\n" + "==> Salary: %d,  Phone#: %s\n",
				getName(), getRank(), getCourse(), getSalary(), getPhone());
	}

}
