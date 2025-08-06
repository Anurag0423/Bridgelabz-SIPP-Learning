import java.util.*;
public class ExceptionPropagation {

    // method1 throws ArithmeticException (unchecked)
    static void method1() {
        int result = 10 / 0; // This will throw ArithmeticException
    }

    // method2 calls method1
    static void method2() {
        method1(); // Exception propagates to here
    }

    // main handles the exception
    public static void main(String[] args) {
        try {
            method2(); // Exception propagates to here
        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main");
        }
    }
}
