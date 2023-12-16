package at.campus02.swe.E2E;

import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;
import at.campus02.swe.logic.CalculatorImpl;
import at.campus02.swe.parser.Parser;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;

public class EndToEndTest {

   Calculator calculator;
   Parser parser;

   public EndToEndTest() {
      this.calculator = new CalculatorImpl();
      this.parser = new Parser(calculator);
   }

   @Test
   public void testFirstFile() throws Exception {
      double result = parser.parse(new File("src/test/resources/EndToEndTest1.xml"));

      assertEquals(33, result, 0);

   }

   @Test
   public void testSecondFile() throws Exception {
      double result = parser.parse(new File("src/test/resources/EndToEndTest2.xml"));

      assertEquals(1, result, 0);

   }
}
