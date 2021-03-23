package T1_407411437;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		final int MAX = 100;
		int n;

		Lotto lottos[] = new Lotto[MAX];
		Scanner input = new Scanner(System.in);

		System.out.print("Enter N: ");
		n = input.nextInt();
		System.out.println();

		for (int i = 0; i < n; i++) {
			
			lottos[i] = new Lotto();
			lottos[i].randgen();
			//System.out.println(lottos[i]);
			
		}
	}

	

}
