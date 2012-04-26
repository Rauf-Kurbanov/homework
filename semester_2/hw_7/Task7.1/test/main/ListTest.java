package main;

import static org.junit.Assert.*;
import org.junit.*;

/**
 *
 * @author paRRadox
 */
public class ListTest {

    public ListTest() {
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
     * Test of add method, of class List for one element.
     */
    @Test
    public void testAddOneElem() {
        Integer value = 100500;
        List<Integer> instance = new List<>();
        instance.add(value);
        assertFalse(instance.isEmpty());
    }

    /**
     * Test of add method, of class List for few elements.
     */
    @Test
    public void testAddFewElem() {
        String value1 = "test";
        String value2 = "my list";
        List<String> instance = new List<>();
        instance.add(value1);
        instance.add(value2);
        assertEquals("test my list ", instance.print());
        //System.out.println(instance.print());
    }

    /**
     * Test of print method, of class List.
     */
    @Test
    public void testPrint() {
        List<Integer> instance = new List<>();
        instance.add(100500);
        String expResult = "100500 ";
        String result = instance.print();
        assertEquals(expResult, result);
    }

    /**
     * Test of clear method, of class List.
     */
    @Test
    public void testClear() {
        List<Integer> instance = new List<>();
        instance.add(123);
        instance.add(897);
        instance.clear();
        assertTrue(instance.isEmpty());
    }

    /**
     * Test of contains method, of class List.
     */
    @Test
    public void testContains() {
        Integer value = 777;
        List<Integer> instance = new List<>();
        instance.add(878);
        instance.add(100);
        instance.add(value);
        assertTrue(instance.contains(value));
    }

    /**
     * Test of isEmpty method, of class List.
     */
    @Test
    public void testIsEmpty() {
        List instance = new List();
        assertTrue(instance.isEmpty());
    }

    /**
     * Test of remove method, of class List.
     */
    @Test
    public void testRemove() {
        List<String> instance = new List<>();
        instance.add("aaa");
        instance.add("ccc");
        instance.add("bbb");
        instance.remove("ccc");
        assertEquals("aaa bbb ", instance.print());
    }
    
    /**
     * test of foreach for this list
     */
    @Test
    public void testForeach() {
        List<Integer> instance = new List<>();
        instance.add(1);
        instance.add(2);
        instance.add(3);
        
        for (Integer a : instance) {
            System.out.println(a);
        }
    }
}
