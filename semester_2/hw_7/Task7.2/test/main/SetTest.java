package main;

import java.util.Iterator;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author paRRadox
 */
public class SetTest {
    
    public SetTest() {
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
     * Test of add method, of class Set.
     */
    @Test
    public void testAdd() {
        Set<String> instance = new Set<>();
        instance.add("ololo");
        instance.add("123");
        instance.add("123");
        //System.out.println(instance.print());
        assertEquals("ololo 123 ", instance.print());
    }

    /**
     * Test of remove method, of class Set.
     */
    @Test
    public void testRemove() {
        Set<Integer> instance = new Set<>();
        instance.add(1);
        instance.add(2);
        instance.add(3);
        instance.remove(2);
        assertEquals("1 3 ", instance.print());
    }

    /**
     * Test of contains method, of class Set.
     */
    @Test
    public void testContains() {
        Set<Integer> instance = new Set<>();
        instance.add(1);
        instance.add(2);
        instance.add(3);
        assertTrue(instance.contains(2));
    }

    /**
     * Test of unoin method, of class Set.
     */
    @Test
    public void testUnion() {
        Set<String> instance1 = new Set<>();
        instance1.add("b");
        instance1.add("c");
        instance1.add("d");
        
        Set<String> instance2 = new Set<>();
        instance2.add("a");
        instance2.add("b");
        instance2.add("c");
        
        Set<String> result = instance1.union(instance2);
        assertEquals("a b c d ", result.print());
    }

    /**
     * Test of intersection method, of class Set.
     */
    @Test
    public void testIntersection() {
       Set<String> instance1 = new Set<>();
        instance1.add("b");
        instance1.add("c");
        instance1.add("d");
        
        Set<String> instance2 = new Set<>();
        instance2.add("a");
        instance2.add("b");
        instance2.add("c");
        
        Set<String> result = instance1.intersection(instance2);
        assertEquals("b c ", result.print());
    }

    /**
     * Test of print method, of class Set.
     */
    @Test
    public void testPrint() {
        Set<String> instance = new Set<>();
        instance.add("a");
        instance.add("b");
        assertEquals("a b ", instance.print());
    }
}
