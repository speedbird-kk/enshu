package Enshu;

public class Enshu06 {

	public int euclid(int a, int b) {

		while (b != 0) {
			return euclid(b, a % b);
		}

		return a;
	}

	public static void main(String[] args) {

		Enshu06 sample = new Enshu06();

		int a = 96;
		int b = 59;

		int gcd = sample.euclid(a, b);

		System.out.printf("The GCD of %d and %d is %d", a, b, gcd);
	}

}
