package Enshu;

public class Enshu03 {

	public static void main(String[] args) {

		int rows = 9;
		int columns = 9;

//		Map<Integer, String> divisible = new HashMap<Integer, String>() {{
//			put(6, "##");
//			put(3, "@@");
//			put(2, "**");
//		}};

		for (int i = 0; i <= rows; i++) {
			for (int j = 1; j <= columns; j++) {
				if (i == 0) {
					System.out.print("\t" + j);
				} else {

					String symbol = "";
					int result = i * j;

					if (result % 6 == 0) {
						symbol = "##";
					} else if (result % 3 == 0) {
						symbol = "@@";
					} else if (result % 2 == 0) {
						symbol = "**";
					} else {
						symbol = Integer.toString(result);
					}

					if (j == 1) {
						System.out.print(i + "\t");
						System.out.print(symbol + "\t");
					} else {
						System.out.print(symbol + "\t");


//						for (Map.Entry<Integer, String> e : divisible.entrySet()) {
//							if (result % e.getKey() == 0) {
//								System.out.print(e.getValue() + "\t");
//							} else {
//								System.out.print(result + "\t");
//							}
//						}

					}
				}
			}
			System.out.println();
		}
	}

}
