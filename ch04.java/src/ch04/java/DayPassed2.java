package ch04.java;

import java.util.Scanner;

public class DayPassed2 {

	public static void main(String[] args) {
		int month, day;
		int year;
		int days = 0;
		String cont;
		int m[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		Scanner gets = new Scanner(System.in);

		while (true) {
			System.out.printf("Enter year: ");

			year = gets.nextInt();
			System.out.printf("Enter month and day: ");
			month = gets.nextInt();
			day = gets.nextInt();
			m[1] = 28;
			days = 0;
			if (leap(year))
				m[1]++;
			for (int i = 0; i < month - 1; i++)
				days += m[i];

			System.out.printf("%d days passed since 1/1/%d\n", days + day, year);
			System.out.printf("Continue (Y/N)? ");
			cont = gets.next();
			if (!cont.toUpperCase().equals("Y"))
				break;

		}
	}

	static boolean leap(int year) {
		if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
			return true;
		else
			return false;
	}

}
