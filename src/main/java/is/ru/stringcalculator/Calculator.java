package is.ru.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator{

	public static int add(String text){
			if(text == ""){
				return 0;
			}
			else{
				if(ifContains(text)){
					String numbers[] = splitString(text);
					negativeException(numbers);
					return sum(numbers);
				}
				else{
					if(Integer.parseInt(text) >= 1000){
						return 0;
					}
					return Integer.parseInt(text);
				}
		}
	}

	private static String[] splitString(String text){
		String numbers[] = text.split("/n|,");
		return numbers;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static int sum(String numbers[]){
		int sum = 0;
		for(String number : numbers){
			if(toInt(number) < 1000){
				sum = sum + toInt(number);
			}
		}
		return sum;
	}

	private static boolean ifContains(String text){
		if(text.contains(",") || text.contains("/n")){
			return true;
		}
		return false;
	}

	private static void negativeException(String numbers[]){
		List<Integer> negNum = new ArrayList<Integer>();
			 for (String number : numbers) {
					 if (toInt(number) < 0) {
							 negNum.add(toInt(number));
					 }
			 }
			 if (!negNum.isEmpty()) {
					 throw new IllegalArgumentException("Negatives not allowed: " + negNum);
			 }
	}

}
