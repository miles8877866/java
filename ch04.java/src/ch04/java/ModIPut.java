package ch04.java;

import java.util.Scanner;

public class ModIPut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int apple, people = 7, q, r;
		System.out.print(people+"�C�H��ī�G�A�n���X��?");
		Scanner input = new Scanner(System.in);
		apple = input.nextInt();
		
		q = apple / people;
		r = apple % people;
		
		System.out.println(people+"�H��"+apple+"��ī�G");
		System.out.println("�C�H��" + q + "�ٳ� " + r + "��");
	}	

}
