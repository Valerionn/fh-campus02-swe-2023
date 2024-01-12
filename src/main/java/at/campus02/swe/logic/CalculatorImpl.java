package at.campus02.swe.logic;


import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;

import java.util.Random;
import java.util.Stack;

public class CalculatorImpl implements Calculator {

    private Stack<Double> stack_ = new Stack<Double>();

    private Random random;

    public CalculatorImpl(int seed) {
        this.random = new Random(seed);
    }

    public CalculatorImpl() {
        this.random = new Random();
    }

    @Override
    public double perform(Operation op) throws CalculatorException {

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
            case mod:
                double d = a % b;
                if (b == 0)
                    throw new CalculatorException("Division by zero");
                return d;
            case mul:
                return a * b;
            case sin:
                return Math.sin(Math.toRadians(a));
            case cos:
                return Math.cos(Math.toRadians(a));
            case random:
                return returnRandom(a,b);
        }

        return 0;
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

    public double returnRandom (double a, double b){
        int min;
        int max;
        // zwei Zahlen auf Stack pushen
        if (a < b){
            min = (int)a;
            max = (int)b;}
        else if (a > b){
            max = (int)a;
            min = (int)b;
        }
        else return (double)a;


        int randomNr = random.nextInt(min,max);
        return (double) randomNr;





        // eine Randomzahl zwischen den 2 Zahlen generieren lassen
    }

}


