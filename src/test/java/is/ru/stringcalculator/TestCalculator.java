package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestCalculator{

	@Test
	public void testEmptyString(){
		assertEquals(0, Calculator.add(""));
	}
	@Test
	public void testOneNumber(){
		assertEquals(1, Calculator.add("1"));
	}
	@Test
	public void testTwoNumber(){
		assertEquals(3, Calculator.add("1,2"));
	}
	@Test
	public void testTwoDelimeters(){
		assertEquals(6, Calculator.add("1,2/n3"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNegativeException(){
		assertEquals(9, Calculator.add("-6,6,4,5"));
	}
}
