package Enshu;

public class Enshu07 {

	public static void main(String[] args) {

		int target = 66;

		int check[] = {2, 3, 5, 7};
		boolean divs[] = {false, false, false, false};

		for (int i = 0; i < check.length; i++) {
			divs[i] = (target % check[i] == 0) ? true : false;
		}

		if (divs[0] && !divs[1] && !divs[2] ||
			divs[0] && divs[1] ||
			!divs[0] && divs[1] ||
			!divs[2] && !divs[3]) {
			System.out.println("◎");
		} else {
			System.out.println("×");
		}

	}

}
