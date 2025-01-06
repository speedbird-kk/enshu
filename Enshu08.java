package Enshu;


class DateException extends Exception {

	/*
	 * Number is outside of range 1 - 31
	 * Start > End
	 */

}


class Sale {

	private int start;
	private int end;

	private int constr_start = 10;
	private int constr_end = 15;

	public void setDates(int start, int end) throws DateException {

		if (start < 1 || end < 1 || start > 31 || end > 31 || start > end) {
			DateException e = new DateException();
			throw e;
		} else {
			this.start = start;
			this.end = end;
		}

	}

	public boolean check_overlap() {

		return start <= constr_end && end > constr_start;

	}

}


public class Enshu08 {

	public static void main(String[] args) {

		Sale sale_period = new Sale();

		try {
			sale_period.setDates(16, 31);

			if (sale_period.check_overlap()) {
				System.out.println("Sale period overlaps with construction period");
			} else {
				System.out.println("Sale period does not overlap with construction period");
			}

		} catch (DateException e) {
			System.out.println("Invalid sale period set");
		}

	}

}
