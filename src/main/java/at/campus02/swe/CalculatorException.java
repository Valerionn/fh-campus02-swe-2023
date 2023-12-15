package at.campus02.swe;

import java.io.Serial;

public class CalculatorException extends Exception {

    private static final long serialVersionUID = 1L;

    public CalculatorException() {
    }

    public CalculatorException(String arg0) {
        super(arg0);
    }


    public CalculatorException(Throwable arg0) {
        super(arg0);
    }

    public CalculatorException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

}
