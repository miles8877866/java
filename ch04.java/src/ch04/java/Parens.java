package ch04.java;

public class Parens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i = 1+3*5+7;//¥ýºâ3*5
		System.out.println("1+3*5+7 = "+i);
		
		i = (1+3)*5+7;//¥ýºâ1+3
		System.out.println("(1+3)*5+7 = "+i);
		
		i = 1+3*(5+7);//¥ýºâ5+7
		System.out.println("1+3*(5+7) = "+i);
	}

}
