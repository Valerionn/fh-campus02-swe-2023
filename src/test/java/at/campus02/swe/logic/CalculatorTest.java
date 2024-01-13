package at.campus02.swe.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;
import at.campus02.swe.Calculator.Operation;

public class CalculatorTest {

    @Test
    public void testSimpleAddOperation() throws Exception {

        //setup
        Calculator calc = new CalculatorImpl();

        //execute
        calc.push(2.0);
        calc.push(3);
        double result = calc.perform(Operation.add);

        //verify
        assertEquals(5, result, 0);


    }

    @Test
    public void testSimpleMulOperation() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.push(2.0);
        calc.push(3);
        double result = calc.perform(Operation.mul);

        assertEquals(6, result, 0);

    }

    @Test
    public void testSimpleDivOperation() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.push(6.0);
        calc.push(2);
        double result = calc.perform(Operation.div);

        assertEquals(3, result, 0);

    }


    //
    @Test(expected = CalculatorException.class)
    public void testPopOnEmptyStack() throws Exception {

        Calculator calc = new CalculatorImpl();
        calc.pop();

    }

    @Test
    public void testDivisionByZero() throws Exception {

        //Setup
        Calculator calc = new CalculatorImpl();
        try {
            calc.push(2);
            calc.push(0);
            calc.perform(Operation.div);

            fail("Exception expected");


        } catch (CalculatorException e) {
            assertEquals("Division by zero", e.getMessage());
            // e.getCause()
        }

    }


    @Test
    public void testSimpleModOperation() throws CalculatorException {

        Calculator calc = new CalculatorImpl();
        calc.push(6.0);
        calc.push(2);
        double result = calc.perform(Operation.mod);

        assertEquals(0, result, 0);

        calc.push(10);
        calc.push(7);
        assertEquals(3, calc.perform(Operation.mod), 0);


    }


    @Test
    public void testModuloByZero() {

        Calculator calc = new CalculatorImpl();

        try {
            calc.push(3);
            calc.push(0);
            calc.perform(Operation.mod);

            fail("Exception expected");

        } catch (CalculatorException e) {
            assertEquals("Division by zero", e.getMessage());
        }
    }


    @Test
    public void testSinOperation() throws CalculatorException {
        Calculator calc = new CalculatorImpl();
        calc.push(30);
        calc.push(0);
        double result = calc.perform(Operation.sin);

        assertEquals(Math.sin(Math.toRadians(30)), result, 0.0001);
    }

    @Test
    public void testCosOperation() throws CalculatorException {
        Calculator calc = new CalculatorImpl();
        calc.push(60);
        calc.push(0);
        double result = calc.perform(Operation.cos);

        assertEquals(Math.cos(Math.toRadians(60)), result, 0.0001);
    }

    @Test
    public void testSkalOperation() throws CalculatorException {
        Calculator calc = new CalculatorImpl();
        calc.push(1);
        calc.push(2);
        calc.push(3);
        calc.push(4);
        calc.push(2);

        int result = calc.calculateSkalar();

        assertEquals(11, result);
    }


    @Test
    public void testRandomNumber() throws CalculatorException {
        Calculator calc = new CalculatorImpl(23);

        int count = 0;

        while (count < 20) {
            calc.push(1);
            calc.push(2);
            double result = calc.perform(Operation.random);
            boolean inbound = false;
            if (result <= 2 && result >= 1)
                inbound = true;
            assertEquals(inbound, true);
            count++;
        }
    }
}