package ch04.java;

import java.util.Scanner;

public class ModIPut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int apple, people = 7, q, r;
		System.out.print(people+"七人分蘋果，要分幾個?");
		Scanner input = new Scanner(System.in);
		apple = input.nextInt();
		
		q = apple / people;
		r = apple % people;
		
		System.out.println(people+"人分"+apple+"個蘋果");
		System.out.println("每人分" + q + "還剩 " + r + "個");
	}	

}
