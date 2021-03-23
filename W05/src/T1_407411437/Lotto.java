package T1_407411437;

import java.util.Arrays;
import java.util.Random;

public class Lotto {
	private Date date;
	private int num[];
	Random rand = new Random();
	
	public Lotto (){
		date = new Date();
		num = new int[6];
	}
	
	public void randgen() {
		int temp;
		date.setYear(rand.nextInt(11)  + 1);
		date.setMonth(rand.nextInt(12)  + 1);
		date.setDay(rand.nextInt(31)  + 1);
		System.out.printf("%d/%02d/%02d   ", date.getYear(), date.getMonth(), date.getDay());
		for (int i = 0; i < 6; i++) {
			do {
				temp = rand.nextInt(49)  + 1;
			} while (duplicate(num, i));

			num[i] = temp;
			System.out.printf("%02d ", num[i]);
		}
		System.out.printf("\n");

	}

	public boolean duplicate(int num[], int pos) {
		for (int i = 0; i < pos; i++) {
			if (num[i] == num[pos])
				return true;
		}
		return false;
	}

	/*public String toString() {
		return "Lotto " + date.getYear() + "/" + date.getMonth() +"/" + date.getDay() + " num=" + Arrays.toString(num) + "]";
	}*/
	
	

}
