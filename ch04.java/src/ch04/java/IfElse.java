package ch04.java;

public class IfElse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 8;

		if (i > 0 && i < 1) {
			System.out.println("0<i<1");
		} else if (i > 1 && i < 5) {
			System.out.println("1<i<5");
		} else if (i > 5 && i < 10) {
			System.out.println("5<i<10");
		} else {
			System.out.println("條件不成立");
		}

	}

}
