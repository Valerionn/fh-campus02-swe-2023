package at.campus02.swe.logic;


import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;

import java.util.Random;
import java.util.Stack;

public class CalculatorImpl implements Calculator {

    private Stack<Double> stack_ = new Stack<Double>();
    private Random random;

    public CalculatorImpl() {
        random = new Random();
    }

    public CalculatorImpl(int seed) {
        random = new Random(seed);
    }

    @Override
    public double perform(Operation op) throws CalculatorException {

        switch (op){
            case sin -> push(0);
            case cos -> push(0);
        }


        double b = pop();
        double a = pop();

        switch (op) {
            case add:
                return a + b;
            case sub:
                return a - b;
            case div:
                double c = a / b;
                if (Double.isInfinite(c))
                    throw new CalculatorException("Division by zero");
                return c;
            case mul:
                return a * b;
            case mod:
                return a % b;
            case sin:
                return Math.sin(a);
            case cos:
                return Math.cos(a);
            case rnd:
                return generateRandomNumber(a,b);
        }
        return 0;
    }

    public int generateRandomNumber(double a, double b) throws CalculatorException{
        double maximum = a;
        double minimum = b;

        if (minimum > maximum) {
            double temp = minimum;
            minimum = maximum;
            maximum = temp;
        }

        //double result = minimum + (maximum - minimum) * Math.random();

        int result = random.nextInt((int)maximum + 1 - (int)minimum) + (int)minimum;
        return result;
    }

    @Override
    public double pop() throws CalculatorException {
        if (stack_.isEmpty())
            throw new CalculatorException();
        return stack_.pop();
    }

    @Override
    public void push(double v) {
        stack_.push(v);
    }

    @Override
    public void clear() {
        stack_.clear();
    }

}
