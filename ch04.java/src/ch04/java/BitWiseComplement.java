package ch04.java;

public class BitWiseComplement {
	
	public static void main(String[] args) {
		
			byte i = 127;//=>01111111
						//~01111111 => 10000000 => -128
			System.out.println("~127: "+ (~i));
			
			
			i = -1; //=>11111111
					//~11111111 => 000000000 => 0
			System.out.println("~(-1) : "+~(-1));
	}
}
