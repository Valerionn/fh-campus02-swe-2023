package at.campus02.swe.logic;


import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;

import java.util.Random;
import java.util.Stack;

public class CalculatorImpl implements Calculator {

    private Random random = new Random();

    private Stack<Double> stack_ = new Stack<Double>();

    public CalculatorImpl() {
    }

    public CalculatorImpl(Random random) {
        this.random = random;
    }

    @Override
    public double perform(Operation op) throws CalculatorException {

        double b;
        double a;

        switch (op) {
            case add:
                b = pop();
                a = pop();
                return a + b;
            case sub:
                b = pop();
                a = pop();
                return a - b;
            case div:
                b = pop();
                a = pop();
                double c = a / b;
                if (Double.isInfinite(c))
                    throw new CalculatorException("Division by zero");
                return c;
            case mul:
                b = pop();
                a = pop();
                return a * b;
            case mod:
                b = pop();
                a = pop();
                return a % b;
            case sin:
                a = pop();
                return Math.sin(Math.toRadians(a));
            case cos:
                a = pop();
                return Math.cos(Math.toRadians(a));
            case random:
                b = pop();  // b = Maximum
                a = pop();  // a = Minimum
                return random.nextInt((int)b - (int)a) + (int)a;
            default:
                throw new CalculatorException("Unsupported operation: " + op);
        }
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
