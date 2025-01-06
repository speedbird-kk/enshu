package Enshu;

import java.util.ArrayList;

/*
 * takes initial input integer from 0 to 9.9999999999 * 10 ^ 11
 * displays integer in Japanese numerals
 * 十 10 ^ 1
 * 百 10 ^ 2
 * 千 10 ^ 3
 * 万 10 ^ 4
 * 億 10 ^ 8
 */

public class Enshu10 {

	private int arabia;
	private int[] exps = {8, 4, 3, 2, 1, 0};
	private int[] placeValues;
	private String[] placeValuesChar = {"億", "万", "千", "百", "十", ""};
	private String[] numerals = {"一", "二", "三", "四", "五", "六", "七", "八", "九"};


	public Enshu10(int num) {

		if (num < 0 || num > 999999999990L) {
			throw new IllegalArgumentException("Number must be between 0 and 9.9999999999 * 10^11");
		}

		this.arabia = num;
		this.placeValues = new int[exps.length];

		for (int i = 0; i < exps.length; i++) {
			placeValues[i] = (int) Math.pow(10, exps[i]);
		}

	}

	public int getArabia() {
		return arabia;
	}

	public int[] getPlaceValues() {
		return placeValues;
	}

	public String[] getPlaceValuesChar() {
		return placeValuesChar;
	}

	public ArrayList<Integer> calcQ(int num, boolean isSecondLayer) {

		int loopFrom = isSecondLayer ? 4 : getPlaceValues().length;

		ArrayList<Integer> results = new ArrayList<Integer>();

		for (int i = getPlaceValues().length - loopFrom; i < getPlaceValues().length; i++) {
			results.add(num / getPlaceValues()[i]);
			num %= getPlaceValues()[i];
		}

		return results;
	}

	public String makeJapanese(ArrayList<Integer> quotients, boolean isSecondLayer) {

		StringBuilder japanese = new StringBuilder();

		int index = 0;

		for (int quotient : quotients) {

			if (quotient > 9) {
				ArrayList<Integer> secondLayer = calcQ(quotient, true);
				showArray(secondLayer);
				japanese.append(makeJapanese(secondLayer, true)).append(placeValuesChar[index]);
			} else if (quotient > 0) {
				if (quotient == 1 &&
					isSecondLayer ? index != 3 : index > 1 && index < 5) {
					japanese.append(placeValuesChar[placeValuesChar.length - 1 -
					                                (quotients.size() - 1 - index)]);
				} else {
					japanese.append(numerals[quotient - 1])
					.append(placeValuesChar[placeValuesChar.length - 1 -
					                        (quotients.size() - 1 - index)]);
				}
			}
			index++;
		}

		return japanese.toString();
	}

	public void showArray(ArrayList<Integer> array) {

		for (int value : array) {
			System.out.print(value + ", ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		int num = 8910003;

		Enshu10 sample = new Enshu10(num);

		ArrayList<Integer> firstLayer = sample.calcQ(num, false);
		sample.showArray(firstLayer);
		String strAll = sample.makeJapanese(firstLayer, false);

		System.out.println(strAll);

	}

}



/*
 * Merge the two methods into one method with output ArrayList
 * since only quotient is required in the main method
 * Add parameter for max place value required and modify loop condition with this param
 * For sub calculation within the place value, only max place value = 3 is required (1000)
 */
/*
 * In main method, call method to calculate quotients
 * Then call method again for 万 and 億 both passing
 * Compose string with .append() and variable placeholders for each place value ?
 */



/*
if (remainder > 9) {

for (int i = exps.length - 3; i < exps.length; i++) {
	int subQuotient = remainder / placeValues[i];
	int subRemainder = remainder % placeValues[i];

}
} else {

}


public static ArrayList<Integer> subCalcQ(int num) {

		ArrayList<Integer> results = new ArrayList<>();

		for (int i = getPlaceValues().length - 3; i < getPlaceValues().length; i++) {

			results.put(num / getPlaceValues()[i]);

		}

	}

public static Map<Integer, Integer> calcQR(int num) {

		Map<Integer, Integer> results = new HashMap<>();

		for (int placeValue : getPlaceValues()) {

			int remainder = num % placeValue;
			results.put(num / placeValue, remainder);

			num = remainder;

		}

		return results;

	}


try {

			String strAll = sample.makeJapanese(firstLayer);
			System.out.println(strAll);

		} catch (ArrayIndexOutOfBoundsException e) {

			String strAll = "";

			if (firstLayer.get(0) > 9) {
				ArrayList<Integer> secondLayer8 = sample.calcQ(firstLayer.get(0), true);
				String str8 = sample.makeJapanese(secondLayer8);
				strAll = str8 + sample.getPlaceValuesChar()[0];
				firstLayer.remove(0);
			}

			if (firstLayer.get(1) > 9) {
				ArrayList<Integer> secondLayer4 = sample.calcQ(firstLayer.get(1), true);
				String str4 = sample.makeJapanese(secondLayer4);
				strAll = str4 + sample.getPlaceValuesChar()[1];
				firstLayer.remove(1);
			}

			strAll += sample.makeJapanese(firstLayer);
			System.out.println(strAll);
		}


*/