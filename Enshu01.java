package Enshu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class AgeException extends Exception {
}

public class Enshu01 {

	public int setAge() throws AgeException {

		while (true) {
			try {
				BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
				String str = br.readLine();
				int age = Integer.parseInt(str);
				if (age < 0) {
					throw new AgeException();
				}
				return age;
			} catch (IOException e) {
				System.out.println("An error has occured.");
				break;
			} catch (NumberFormatException e) {
				System.out.println("Please enter an integer value: ");
			}
		}
		return -1;

	}

	public static void main(String[] args) {

		Enshu01 sample = new Enshu01();
		System.out.println("Enter age: ");

		while (true) {
			try {
				int age = sample.setAge();

				if (age >= 0 && age <= 19) {
					System.out.println("未成年です。\n地方自治体によって医療費が\\200のところも。");
				} else if (age >= 20 && age <= 59) {
					System.out.println("成年です。\n飲酒・喫煙は控えめに。");
				} else {
					System.out.println("定年後も元気100% で 過ごしてください。");
				}
				break;
			} catch (AgeException e) {
				System.out.println("Please enter a valid age: ");
			}

		}

	}
}