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

    Calculator(AbstractStack opStack) {
        this.opStack = opStack;
    }

    public void push(Float value) {
        if (opStack.size() < 2) {
            opStack.push(value);
        } else {
            System.err.println("Invalid number of variables");
        }
    }

    public void plus() {
        Float result = (Float) opStack.pop() + (Float) opStack.pop();
        opStack.push(result);
    }

    public void minus() {
        Float rightValue = (Float) opStack.pop();
        Float leftValue = (Float) opStack.pop();
        opStack.push(leftValue - rightValue);
    }

    public void multiply() {
        Float result = (Float) opStack.pop() * (Float) opStack.pop();
        opStack.push(result);
    }

    public void divide() {
        Float rightValue = (Float) opStack.pop();
        Float leftValue = (Float) opStack.pop();
        opStack.push(leftValue / rightValue);
    }

    public String printResult() {
        if (opStack.size() == 1) {
            return opStack.pop().toString();
        } else {
            return "Not counted yet";
        }
    }
    protected AbstractStack opStack;
}
