package main;

import static org.junit.Assert.assertEquals;
import org.junit.*;

/**
 *
 * @author paRRadox
 */
public class CalculatorTest {

    public CalculatorTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of push method, of class Calculator with ArrayStack.
     */
    @Test
    public void testPushArrayStack() {
        ArrayStack opStack = new ArrayStack();
        Float value = new Float(100.500);
        Calculator instance = new Calculator(opStack);
        instance.push(value);
        assertEquals(value.toString(), instance.printResult());
    }

    /**
     * Test of push method, of class Calculator with LinkedStack.
     */
    @Test
    public void testPushLinkedStack() {
        LinkedStack opStack = new LinkedStack();
        Float value = new Float(100.500);
        Calculator instance = new Calculator(opStack);
        instance.push(value);
        assertEquals(value.toString(), instance.printResult());
    }

    /**
     * Test of plus method, of class Calculator with ArrayStack.
     */
    @Test
    public void testPlusArrayStack() {
        ArrayStack opStack = new ArrayStack();
        Calculator instance = new Calculator(opStack);
        instance.push(new Float(2));
        instance.push(new Float(2));
        instance.plus();
        Float result = new Float(4);
        assertEquals(result.toString(), instance.printResult());
    }

    /**
     * Test of plus method, of class Calculator with LinkedStack.
     */
    @Test
    public void testPlusLinkedStack() {
        LinkedStack opStack = new LinkedStack();
        Calculator instance = new Calculator(opStack);
        instance.push(new Float(2));
        instance.push(new Float(2));
        instance.plus();
        Float result = new Float(4);
        assertEquals(result.toString(), instance.printResult());
    }

    /**
     * Test of minus method, of class Calculator with ArrayStack.
     */
    @Test
    public void testMinusArrayStack() {
        ArrayStack opStack = new ArrayStack();
        Calculator instance = new Calculator(opStack);
        instance.push(new Float(3));
        instance.push(new Float(2));
        instance.minus();
        Float result = new Float(1);
        assertEquals(result.toString(), instance.printResult());
    }

    /**
     * Test of plus minus, of class Calculator with LinkedStack.
     */
    @Test
    public void testMinusLinkedStack() {
        LinkedStack opStack = new LinkedStack();
        Calculator instance = new Calculator(opStack);
        instance.push(new Float(3));
        instance.push(new Float(1));
        instance.minus();
        Float result = new Float(2);
        assertEquals(result.toString(), instance.printResult());
    }

    /**
     * Test of multiply method, of class Calculator with ArrayStack.
     */
    @Test
    public void testMultiplyArrayStack() {
        ArrayStack opStack = new ArrayStack();
        Calculator instance = new Calculator(opStack);
        instance.push(new Float(3));
        instance.push(new Float(2));
        instance.multiply();
        Float result = new Float(6);
        assertEquals(result.toString(), instance.printResult());
    }

    /**
     * Test of multiply method, of class Calculator with LinkedStack.
     */
    @Test
    public void testMultiplyLinkedStack() {
        LinkedStack opStack = new LinkedStack();
        Calculator instance = new Calculator(opStack);
        instance.push(new Float(3));
        instance.push(new Float(2));
        instance.multiply();
        Float result = new Float(6);
        assertEquals(result.toString(), instance.printResult());
    }

    /**
     * Test of divide method, of class Calculator with ArrayStack.
     */
    @Test
    public void testDivideyArrayStack() {
        ArrayStack opStack = new ArrayStack();
        Calculator instance = new Calculator(opStack);
        instance.push(new Float(3));
        instance.push(new Float(2));
        instance.divide();
        Float result = new Float(1.5);
        assertEquals(result.toString(), instance.printResult());
    }

    /**
     * Test of divide method, of class Calculator with LinkedStack.
     */
    @Test
    public void testDivideyLinkedStack() {
        LinkedStack opStack = new LinkedStack();
        Calculator instance = new Calculator(opStack);
        instance.push(new Float(3));
        instance.push(new Float(2));
        instance.divide();
        Float result = new Float(1.5);
        assertEquals(result.toString(), instance.printResult());
    }

    /**
     * Test of printResult method, of class Calculator with ArrayStack.
     */
    @Test
    public void testPrintResultArrayStack() {
        ArrayStack opStack = new ArrayStack();
        Calculator instance = new Calculator(opStack);
        instance.push(new Float(3));
        instance.push(new Float(2));
        String expResult = "Not counted yet";
        String result = instance.printResult();
        assertEquals(expResult, result);
    }

    /**
     * Test of printResult method, of class Calculator with LinkedStack.
     */
    @Test
    public void testPrintResultLinkedStack() {
        LinkedStack opStack = new LinkedStack();
        Calculator instance = new Calculator(opStack);
        instance.push(new Float(3));
        String expResult = "3.0";
        String result = instance.printResult();
        assertEquals(expResult, result);
    }
}
