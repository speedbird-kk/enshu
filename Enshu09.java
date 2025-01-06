package Enshu;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Enshu09 {

	public static void main(String[] args) {

		ArrayList<Integer> primes = new ArrayList<Integer>();
		Map<Integer, Integer> primeFactors;

		int min = 4000;
		int max = 5000;
		int initFactor = 17; // enter prime

		// generate list of prime numbers
		for (int i = 2; i < initFactor + 1; i++) {
			boolean isPrime = true;
			for (int j = 2; j * j <= i; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primes.add(i);
			}
		}

		for (int i = min; i < max; i++) {

			if (i % initFactor == 0) {

				primeFactors = new TreeMap<>(); // tree map for sorted order

				int quotient = i;

				for (Integer prime : primes) {
					int exp = 0;
					while (quotient % prime == 0) {
						quotient /= prime;
						exp++;
					}
					if (exp > 0) {
						primeFactors.put(prime, exp);
					}
				}

				// handles case where remaining quotient is a prime factor
				if (quotient > 1) {
					primeFactors.put(quotient, 1);
				}

				if (!primeFactors.isEmpty()) {

					StringBuilder primeFactorisation = new StringBuilder();

					for (Map.Entry<Integer, Integer> entry : primeFactors.entrySet()) {
						primeFactorisation.append(entry.getKey()).append(" ^ ").append(entry.getValue()).append(" * ");
					}

					// remove the last " * "
					primeFactorisation.setLength(primeFactorisation.length() - 3);

					System.out.println(i + " = " + primeFactorisation);

				}

			}

		}

	}

}