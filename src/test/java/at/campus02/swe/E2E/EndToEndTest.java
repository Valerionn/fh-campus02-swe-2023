package at.campus02.swe.E2E;

import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;
import at.campus02.swe.logic.CalculatorImpl;
import at.campus02.swe.parser.Parser;
import org.junit.Test;

import javax.xml.stream.XMLStreamException;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;

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

   @Test
   public void testRandom() throws Exception {
      parser = new Parser(new CalculatorImpl(23));

      boolean fehlgeschlagen = false;
      int count = 0;

      while (count < 15) {
         double result = parser.parse(new File("src/test/resources/RandomTest.xml"));
         if ((result <  10) || (result > 20)) {
            fehlgeschlagen = true;}
            count++;
         }

         assertFalse(fehlgeschlagen);


      }
   }

