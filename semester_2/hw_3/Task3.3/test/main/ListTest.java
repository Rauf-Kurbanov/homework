package main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.*;

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
     * Test of add method, of class List.
     */
    @Test
    public void testAdd() {
        Object value = 100500;
        List instance = new List();
        instance.add(value);
        Assert.assertEquals(value, instance.get(0));
    }

    /**
     * Test of print method, of class List.
     */
    @Test
    public void testPrint() {
        List instance = new List();
        instance.print();
    }

    /**
     * Test of clear method, of class List.
     */
    @Test
    public void testClear() {
        List instance = new List();
        instance.clear();
        Assert.assertEquals(instance.get(0), null);
    }

    /**
     * Test of contains method, of class List.
     */
    @Test
    public void testIsContains() {
        int value = 3;
        List instance = new List();
        for (int i = 0; i < 5; i++) {
            instance.add(i);
        }
        assertTrue(instance.isContains(value));
    }
    
    @Test
    public void testContainsForEmpty() {
        int value = 7;
        List instance = new List();
        assertFalse(instance.isContains(value));
    }

    /**
     * Test of get method, of class List.
     */
    @Test
    public void testGet() {
        int index = 3;
        List instance = new List();
        int expResult = 100500;
        for (int i = 0; i < 5; i++) {
            instance.add(expResult - 3 + i);
        }
        Object result = instance.get(index);
        assertEquals(expResult, result);
    }

    /**
     * Test of indexOf method, of class List.
     */
    @Test
    public void testIndexOf() {
        Object value = 8;
        List instance = new List();
        int expResult = -1;
        for (int i = 10; i < 500; i++) {
            instance.add(i);
        }
        instance.clear();
        int result = instance.indexOf(value);
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmpty method, of class List.
     */
    @Test
    public void testIsEmpty() {
        List instance = new List();
        instance.clear();
        instance.set(5, 100);
        assertTrue(instance.isEmpty());
    }

    /**
     * Test of remove method, of class List.
     */
    @Test
    public void testRemove() {
        Object value = 3;
        List instance = new List();
        for (int i = 0; i < 5; i++) {
            instance.add(i);
        }
        instance.remove(value);
        assertFalse(instance.isContains(value));
    }

    /**
     * Test of set method, of class List.
     */
    @Test
    public void testSet() {
        int index = 5;
        Object value = 100500;
        List instance = new List();
        instance.set(index, value);
        Assert.assertEquals(null, instance.get(index));
    }
}
