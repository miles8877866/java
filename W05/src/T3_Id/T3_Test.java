package T3_Id;

public class T3_Test {

	public static void main(String[] args) {

		final int MAX = 100;
		Employee employee[] = new Employee[MAX];
		int empC = 0;

		employee[empC] = new Professor("Jack Smith", "0968123456", 90000);
		((Professor) employee[empC]).setCourse("Data Structure"); // �б¡u��Ƶ��c�v�ҵ{
		((Professor) employee[empC]).setRank("Full"); // ���б�
		((Professor) employee[empC++]).setDeptName("Computer Science"); // ��T��Ǩt
		employee[empC] = new Professor("Steve Bush", "0921345678", 85000);

		((Professor) employee[empC]).setCourse("Operating Systems"); // �б¡u�@�~�t�Ρv�ҵ{
		((Professor) employee[empC]).setRank("Associate"); //
		// �Ʊб�
		((Professor) employee[empC++]).setDeptName("Electrical Engineering");
		employee[empC] = new TA("John McDonold", "0988987654", 21000); // TA:�оǧU�z
		//
		((TA) employee[empC]).setGrad("Master"); // �Ӥh�Z
		((TA) employee[empC]).setCourse("Basic ComputerConcepts"); // �u��T���סv�U�Сv�U��
		((TA) employee[empC++]).setDeptName("Computer Science");
		employee[empC] = new TA("Amy Miller", "0938246801", 25000, "Doctoral"); // �դh�Z
		//
		((TA) employee[empC]).setCourse("C Programming"); //
		// �uC�{���y���v�U�Сv�U��
		((TA) employee[empC++]).setDeptName("Civil Engineering");
		employee[empC] = new RA("Alex Jones", "0939876543", 20000); //
		// RA:��s�U�z
		((RA) employee[empC]).setGrad("Doctoral");
		((RA) employee[empC]).setResearchID("NSC-2008-10");
		// //��s�p�e�s��
		((RA) employee[empC++]).setDeptName("Computer Science");
		employee[empC] = new RA("MaryAdams", "0941678954", 23000, "Master");
		((RA) employee[empC]).setResearchID("NSC-2008-20");
		((RA) employee[empC]).setDeptName("Mathematics");

		for(int i=0 ;i<empC; i++) {
			System.out.print(employee[i] + "\n\n");
		}
		
		
	}

}
