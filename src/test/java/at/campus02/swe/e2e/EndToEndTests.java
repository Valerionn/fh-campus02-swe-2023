package at.campus02.swe.e2e;

import at.campus02.swe.Calculator;
import at.campus02.swe.logic.CalculatorImpl;
import at.campus02.swe.parser.Parser;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class EndToEndTests {
	@Test
	public void CalculateTheSumOfTwoMultiplications() throws Exception {
		Calculator cal = new CalculatorImpl();

		Parser parser = new Parser(cal);
		double result = parser.parse(new File("src/test/resources/e2e-test01.xml"));

		assertEquals(37, result, 0);
	}

	@Test
	public void CalculateTheDifferenceOfAnAdditionAndAMultiplication() throws Exception {
		Calculator cal = new CalculatorImpl();

		Parser parser = new Parser(cal);
		double result = parser.parse(new File("src/test/resources/e2e-test02.xml"));

		assertEquals(-32, result, 0);
	}
}
