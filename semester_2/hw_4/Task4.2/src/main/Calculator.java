/*
 * Реализовать стековый калькулятор. Стек реализовать двумя способами 
 * (например, массивом или списком) в двух разных классах на основе 
 * одного интерфейса. Стековый калькулятор должен знать только про интерфейс. 
 * Юнит-тесты обязательны.
 */
package main;

/**
 *
 * @author paRRadox
 */
public class Calculator {
    
    /**
     * Basic constructor of calculator
     * @param opStack stack of calculator's values
     */
    Calculator(AbstractStack opStack) {
        this.opStack = opStack;
    }
    
    /**
     * Add a value to calcutate
     * @param value value to calcutate
     */
    public void push(Float value) {
        if (opStack.size() < 2) {
            opStack.push(value);
        } else {
            System.err.println("Invalid number of variables");
        }
    }
    
    /**
     * Add the values
     */
    public void plus() {
        Float result = (Float) opStack.pop() + (Float) opStack.pop();
        opStack.push(result);
    }
    
    /**
     * Subtract the values
     */
    public void minus() {
        Float rightValue = (Float) opStack.pop();
        Float leftValue = (Float) opStack.pop();
        opStack.push(leftValue - rightValue);
    }
    
    /**
     * Multiply the values
     */
    public void multiply() {
        Float result = (Float) opStack.pop() * (Float) opStack.pop();
        opStack.push(result);
    }
    
    /**
     * Divide the values
     */
    public void divide() {
        Float rightValue = (Float) opStack.pop();
        Float leftValue = (Float) opStack.pop();
        opStack.push(leftValue / rightValue);
    }
    
    /**
     * Print the result of calculation
     * @return result of calculation
     */
    public String printResult() {
        if (opStack.size() == 1) {
            return opStack.pop().toString();
        } else {
            return "Not counted yet";
        }
    }
    protected AbstractStack opStack;
}
