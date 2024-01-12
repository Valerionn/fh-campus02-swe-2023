package at.campus02.swe.e2e;

import at.campus02.swe.Calculator;
import at.campus02.swe.logic.CalculatorImpl;
import at.campus02.swe.parser.Parser;
import org.junit.Test;

import java.io.File;
import java.util.Random;

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

	@Test
	public void CalculateTheSinOf90Degree() throws Exception {
		Calculator cal = new CalculatorImpl();

		Parser parser = new Parser(cal);
		double result = parser.parse(new File("src/test/resources/e2e-test03-sin.xml"));

		assertEquals(1, result, 0);
	}

	@Test
	public void CalculateTheCosOf90Degree() throws Exception {
		Calculator cal = new CalculatorImpl();

		Parser parser = new Parser(cal);
		double result = parser.parse(new File("src/test/resources/e2e-test04-cos.xml"));

		assertEquals(1, result, 0);
	}

	@Test
	public void CalculateARandomBetween7And12() throws Exception {
		Calculator cal = new CalculatorImpl(new Random(112));

		Parser parser = new Parser(cal);
		int result = (int) parser.parse(new File("src/test/resources/e2e-test05-random.xml"));

		assertEquals(11, result, 0);
	}

}
