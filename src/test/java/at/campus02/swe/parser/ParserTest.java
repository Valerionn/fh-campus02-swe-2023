package at.campus02.swe.parser;

import java.io.File;
import java.io.FileNotFoundException;

import at.campus02.swe.CalculatorException;
import at.campus02.swe.logic.CalculatorImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

import at.campus02.swe.Calculator;
import at.campus02.swe.Calculator.Operation;


public class ParserTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNullParser() {
        new Parser(null);
    }

    @Test(expected = FileNotFoundException.class)
    public void testParserInvalidFile() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("invalid"));
    }

    @Test
    public void testParserTest01Xml() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("src/test/resources/test01.xml"));

        verify(cal).push(1.0);
        verify(cal).push(2.0);
        verify(cal).perform(Operation.add);
        verifyNoMoreInteractions(cal);
    }
    @Test
    public void testParserTest04Xml() throws Exception {
        Calculator cal = mock(Calculator.class);
        Parser parser = new Parser(cal);
        parser.parse(new File("src/test/resources/test04.xml"));
        verify(cal).push(4.0);
        verify(cal).push(2.0);
        verify(cal).perform(Operation.mod);
        verifyNoMoreInteractions(cal);
    }
    @Test
    public void testParserTest05Xml() throws Exception {
        Calculator cal = mock(Calculator.class);
        Parser parser = new Parser(cal);
        parser.parse(new File("src/test/resources/test05.xml"));
        verify(cal).push(4.0);
        verify(cal).push(8.0);
        verify(cal).push(2.0);
        verify(cal).perform(Operation.mod);
        verifyNoMoreInteractions(cal);
    }

    @Test
    public void testParserTest09Xml() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("src/test/resources/test09.xml"));

        verify(cal).push(90);
        verify(cal).perform(Operation.sin);

        verifyNoMoreInteractions(cal);
    }

    @Test
    public void testParserTest10Xml() throws Exception {

        Calculator cal = mock(Calculator.class);

        Parser parser = new Parser(cal);
        parser.parse(new File("src/test/resources/test10.xml"));

        verify(cal).push(0);
        verify(cal).push(90);
        verify(cal).perform(Operation.cos);

        verifyNoMoreInteractions(cal);
    }

    }









