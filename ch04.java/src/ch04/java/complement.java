package ch04.java;

public class complement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean lightIsOn = false; //代表有開燈?
		System.out.println("現在有開燈?"+lightIsOn);
		
		lightIsOn = !lightIsOn; //做反向運算
		System.out.println("?"+lightIsOn);
	}

}
