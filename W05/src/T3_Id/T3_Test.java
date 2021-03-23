package T3_Id;

public class T3_Test {

	public static void main(String[] args) {

		final int MAX = 100;
		Employee employee[] = new Employee[MAX];
		int empC = 0;

		employee[empC] = new Professor("Jack Smith", "0968123456", 90000);
		((Professor) employee[empC]).setCourse("Data Structure"); // 教授「資料結構」課程
		((Professor) employee[empC]).setRank("Full"); // 正教授
		((Professor) employee[empC++]).setDeptName("Computer Science"); // 資訊科學系
		employee[empC] = new Professor("Steve Bush", "0921345678", 85000);

		((Professor) employee[empC]).setCourse("Operating Systems"); // 教授「作業系統」課程
		((Professor) employee[empC]).setRank("Associate"); //
		// 副教授
		((Professor) employee[empC++]).setDeptName("Electrical Engineering");
		employee[empC] = new TA("John McDonold", "0988987654", 21000); // TA:教學助理
		//
		((TA) employee[empC]).setGrad("Master"); // 碩士班
		((TA) employee[empC]).setCourse("Basic ComputerConcepts"); // 「資訊概論」助教」助教
		((TA) employee[empC++]).setDeptName("Computer Science");
		employee[empC] = new TA("Amy Miller", "0938246801", 25000, "Doctoral"); // 博士班
		//
		((TA) employee[empC]).setCourse("C Programming"); //
		// 「C程式語言」助教」助教
		((TA) employee[empC++]).setDeptName("Civil Engineering");
		employee[empC] = new RA("Alex Jones", "0939876543", 20000); //
		// RA:研究助理
		((RA) employee[empC]).setGrad("Doctoral");
		((RA) employee[empC]).setResearchID("NSC-2008-10");
		// //研究計畫編號
		((RA) employee[empC++]).setDeptName("Computer Science");
		employee[empC] = new RA("MaryAdams", "0941678954", 23000, "Master");
		((RA) employee[empC]).setResearchID("NSC-2008-20");
		((RA) employee[empC]).setDeptName("Mathematics");

		for(int i=0 ;i<empC; i++) {
			System.out.print(employee[i] + "\n\n");
		}
		
		
	}

}
