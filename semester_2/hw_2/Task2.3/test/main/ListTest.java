/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import org.junit.*;
import static org.junit.Assert.*;

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
        instance = new List();
    }

    @After
    public void tearDown() {
    }
    
    List instance;
    
    /**
     * Test of add method, of class List.
     */
    @Test
    public void testAdd() {
        Object value = 100500;
        instance.add(value);
        Assert.assertEquals(value, instance.get(0));
    }

    /**
     * Test of print method, of class List.
     */
    @Test
    public void testPrint() {
        instance.print();
    }

    /**
     * Test of clear method, of class List.
     */
    @Test
    public void testClear() {
        instance.clear();
        Assert.assertEquals(instance.get(0), null);
    }

    /**
     * Test of contains method, of class List.
     */
    @Test
    public void testContains() {
        int value = 3;
        boolean expResult = true;
        for (int i = 0; i < 5; i++) {
            instance.add(i);
        }
        boolean result = instance.contains(value);
        assertEquals(expResult, result);
    }

    /**
     * Test of get method, of class List.
     */
    @Test
    public void testGet() {
        int index = 3;
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
        boolean expResult = true;
        instance.clear();
        instance.set(5, 100);
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class List.
     */
    @Test
    public void testRemove() {
        Object value = 3;
        for (int i = 0; i < 5; i++) {
            instance.add(i);
        }
        instance.remove(value);
        Assert.assertEquals(instance.contains(value), false);
    }

    /**
     * Test of set method, of class List.
     */
    @Test
    public void testSet() {
        int index = 5;
        Object value = 100500;
        instance.set(index, value);
        Assert.assertEquals(null, instance.get(index));
    }
}
