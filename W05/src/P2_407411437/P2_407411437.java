package P2_407411437;

public class P2_407411437 {

	public static void main(String[] args) {
		Employee emp[] = new Employee[10];
		int empCount = 0;
		emp[empCount++] = new SalariedEmployee("John", "A123456789", 1100, "Manager", 60000);
		emp[empCount++] = new HourlyEmployee("Joyce", "J376829345", 1200, "Secretary", 2500, 130);// hours=2500,
																									// hourlyPay=130
		SalariedEmployee salariedEmp = new SalariedEmployee();
		salariedEmp.setSalary(50000); // Salary=50000
		salariedEmp.setName("David");
		salariedEmp.setId("B135798642");
		salariedEmp.setEmpID(1151);
		salariedEmp.setTitle("Engineer");
		emp[empCount++] = salariedEmp;

		for (int i = 0; i < empCount; i++) {
			System.out.println(emp[i]);
			System.out.printf("Year earning: %d\n", emp[i].yearEarning());
			System.out.println("--------------------------------------");
		}

	}

}
