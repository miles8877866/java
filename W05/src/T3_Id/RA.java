package T3_Id;

public class RA extends Dept{
	
	private String Grad;
	private String ResearchID;
	
	
	public RA(String name, String phone, int salary, String DeptName) {
		super(name, phone, salary, DeptName);
	}

	public RA(String name, String phone, int salary) {
		super(name, phone, salary);
	}

	public String getGrad() {
		return Grad;
	}

	public void setGrad(String grad) {
		this.Grad = grad;
	}

	public String getResearchID() {
		return ResearchID;
	}

	public void setResearchID(String researchID) {
		this.ResearchID = researchID;
	}

	@Override
	public String toString() {
		return String.format("%s: Research Assistant of %s.\n" + 
				"==> Research ID: %s\n" + 
				"==> Salary: %d,  Phone#: %s\n" 
				, Name, getDeptName(), getResearchID(), getSalary(), getPhone());
	}
	
	
	
}
