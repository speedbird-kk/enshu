package Enshu;

public class Enshu02 {

	public static void main(String[] args) {

		int rows = 9;
		int columns = 9;

		for (int i = 0; i <= rows; i++) {
			for (int j = 1; j <= columns; j++) {
				if (i == 0) {
					System.out.print("\t" + j);
				} else {
					if (j == 1) {
						System.out.print(i + "\t");
						System.out.print(i * j + "\t");
					} else {
						System.out.print(i * j + "\t");
					}
				}
			}
			System.out.println();
		}
	}

}
