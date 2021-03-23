package P1_1D;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
	
		int x, y, z;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter three positive integers: ");
		x = input.nextInt();
		y = input.nextInt();
		z = input.nextInt();
		
		Comp comp = new Comp(x, y, z);
		
		System.out.printf("sum(%d,%d,%d) = %d\n", x, y, z, comp.sum());
		System.out.printf("max(%d,%d,%d) = %d\n", x, y, z, comp.max());
		System.out.printf("min(%d,%d,%d) = %d\n", x, y, z, comp.min());
	}

}
