package at.campus02.swe;

public interface Calculator {

    enum Operation {

        add, sub, mul, div, sin, cos, mod, random;
    };

    void push(double value);

    double pop() throws CalculatorException;

    double perform(Operation op) throws CalculatorException;

    void clear();
}