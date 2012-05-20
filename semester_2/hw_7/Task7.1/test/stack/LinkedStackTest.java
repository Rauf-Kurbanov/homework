package stack;

import static org.junit.Assert.*;
import org.junit.*;

/**
 *
 * @author paRRadox
 */
public class LinkedStackTest {

    public LinkedStackTest() {
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
     * Test of size method, of class LinkedStack.
     */
    @Test
    public void testSize() {
        Stack<Integer> instance = new LinkedStack<>();
        instance.push(1);
        instance.push(2);
        instance.push(3);
        assertEquals(3, instance.size());
    }

    /**
     * Test of isEmpty method, of class LinkedStack.
     */
    @Test
    public void testIsEmpty() {
        Stack<String> instance = new LinkedStack<>();
        assertTrue(instance.isEmpty());
    }

    /**
     * Test of push method, of class LinkedStack.
     */
    @Test
    public void testPush() {
        Stack<String> instance = new LinkedStack<>();
        instance.push("ololo");
        assertEquals("ololo", instance.pop());
    }

    /**
     * Test of pop method, of class LinkedStack.
     */
    @Test
    public void testPop() {
        Stack<Integer> instance = new LinkedStack<>();
        Integer value = 100500;
        instance.push(value);
        assertEquals(value, instance.pop());
    }

    /**
     * Test of peek method, of class LinkedStack.
     */
    @Test
    public void testPeek() {
        Stack<String> instance = new LinkedStack<>();
        instance.push("I'm too lazy");
        instance.push("to write long tests");
        assertEquals("to write long tests", instance.peek());
    }
}
