package Enshu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Enshu04 {

	public static void main(String[] args) {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine();
			if (str.equals(str.toLowerCase())) {
				System.out.println(str.toUpperCase());
			} else if (str.equals(str.toUpperCase())) {
				System.out.println(str.toLowerCase());
			} else {
				System.out.println("Input has mixed case");
			}
		} catch (IOException e) {
			System.out.println("An error has occured");
		}
	}
}
