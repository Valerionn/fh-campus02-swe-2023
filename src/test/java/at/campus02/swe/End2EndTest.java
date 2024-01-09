package at.campus02.swe;

import at.campus02.swe.logic.CalculatorImpl;
import at.campus02.swe.parser.Parser;
import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class End2EndTest {
    @Test
    public void testCalculationFromFile1() throws Exception {
        testAddE2E("src/test/resources/test08.xml");
    }

    @Test
    public void testCalculationFromFile2() throws Exception {
        testAddE2E("src/test/resources/test07.xml");
    }

    public void testAddE2E(String fileName) throws CalculatorException, XMLStreamException, FileNotFoundException {
        Calculator calculator = new CalculatorImpl();
        Parser parser = new Parser(calculator);

        File file = new File(fileName);
        double result = parser.parse(file);

        if ("src/test/resources/test08.xml".equals(fileName)) {
            assertEquals(3, result, 0);
        } else if ("src/test/resources/test07.xml".equals(fileName)) {
            assertEquals(6, result, 0);
        }
    }
}
