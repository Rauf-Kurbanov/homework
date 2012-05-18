package main;

import java.util.LinkedList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.*;

/**
 *
 * @author paRRadox
 */
public class BubbleSorterTest {

    public BubbleSorterTest() {
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
     * Test of sort method, of class BubbleSorter.
     */
    @Test
    public void testSortInteger() {
        Compareter<Integer> comp = new Compareter<>();
        BubbleSorter<Integer> instance = new BubbleSorter<>(comp);
        List<Integer> input = new LinkedList<>();
        for (int i = 3; i > 0 ; --i) {
            input.add(i);
        }
        
        List<Integer> expResult = new LinkedList<>();
        for (int i = 1; i < 4; ++i) {
            expResult.add(i);
        }
        
        List result = instance.sort(input);
        assertEquals(expResult, result);
    }
    
    @Test 
    public void testSortString() {
        Compareter<String> comp = new Compareter<>();
        BubbleSorter<String> instance = new BubbleSorter<>(comp);
        List<String> input = new LinkedList<>();
        input.add("Clolo");
        input.add("Blolo");
        input.add("Alolo");
        
        List<String> expResult = new LinkedList<>();
        expResult.add("Alolo");
        expResult.add("Blolo");
        expResult.add("Clolo");
        
        List result = instance.sort(input);
        assertEquals(expResult, result);
    }
}
