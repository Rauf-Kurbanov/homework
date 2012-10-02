package main;

import java.util.Iterator;
import org.junit.*;
import static org.junit.Assert.*;

public class BSTTest {
    
    public BSTTest() {
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
     * Test of add method, of class BST.
     */
    @Test
    public void testAdd() {
        BST<Integer> instance = new BST();
        instance.add(5);
        instance.add(2);
        instance.add(8);
        
        assertEquals("2 5 8 ", instance.print());
    }

    /**
     * Test of iterator method, of class BST.
     */
    @Test
    public void testForeach() {
        BST<Integer> instance = new BST();
        instance.add(5);
        instance.add(2);
        instance.add(2);
        instance.add(8);
        instance.add(9);
        instance.add(0);
        
        Iterator it = instance.iterator();

        for (Integer i : instance) {
            assertEquals(it.next(), i);
        }
    }
}
