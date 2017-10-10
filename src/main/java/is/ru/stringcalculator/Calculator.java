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
					String numbers[] = text.split("/n|,");
					negativeException(numbers);
					return sum(numbers);
				}
				else{
					return Integer.parseInt(text);
				}
		}
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static int sum(String numbers[]){
		int sum = 0;
		for(String number : numbers){
			sum = sum + toInt(number);
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
		List<Integer> negatives = new ArrayList<Integer>();
			 for (String number : numbers) {
					 if (toInt(number) < 0) {
							 negatives.add(toInt(number));
					 }
			 }
			 if (!negatives.isEmpty()) {
					 throw new IllegalArgumentException("Negatives not allowed: " + negatives);
			 }
	}

}
