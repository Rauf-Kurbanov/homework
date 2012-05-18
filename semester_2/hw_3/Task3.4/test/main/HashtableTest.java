package main;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author paRRadox
 */
public class HashtableTest {

    public HashtableTest() {
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
     * Test of addHT method, of class Hashtable with default hash function.
     */
    @Test
    public void testAddHTDefault() {
        String token = "Test";
        HashFunc HashFunc = new DefaultHashFunc();
        Hashtable instance = new Hashtable(HashFunc);
        instance.addHT("ololo");
        instance.addHT(token);
        assertEquals(true, instance.isExist(token));
    }

    /**
     * Test of exist method, of class Hashtable with default hash function if it
     * is empty.
     */
    @Test
    public void testIsExistForEmptyDefault() {
        String token = "ololo";
        HashFunc HashFunc = new DefaultHashFunc();
        Hashtable instance = new Hashtable(HashFunc);
        boolean expResult = false;
        boolean result = instance.isExist(token);
        assertEquals(expResult, result);
    }

    /**
     * Test of exist method, of class Hashtable with default hash function if it
     * is not empty.
     */
    @Test
    public void testIsExistExistForNotEmptyDefault() {
        String token = "ololo";
        HashFunc HashFunc = new DefaultHashFunc();
        Hashtable instance = new Hashtable(HashFunc);
        instance.addHT("123");
        instance.addHT(token);
        boolean expResult = true;
        boolean result = instance.isExist(token);
        assertEquals(expResult, result);
    }

    /**
     * Test of size method, of class Hashtable. A hash function does not matter.
     */
    @Test
    public void testSize() {
        int expSize = 50;
        HashFunc HashFunc = new DefaultHashFunc();
        Hashtable instance = new Hashtable(expSize, HashFunc);
        assertEquals(expSize, instance.size());
    }

    /**
     * Test of addHT method, of class Hashtable with simple hash function.
     */
    @Test
    public void testAddHTSimple() {
        String token = "Test";
        HashFunc HashFunc = new SimpleHashFunc();
        Hashtable instance = new Hashtable(HashFunc);
        instance.addHT("ololo");
        instance.addHT(token);
        assertEquals(true, instance.isExist(token));
    }

    /**
     * Test of exist method, of class Hashtable with simple hash function if it
     * is empty.
     */
    @Test
    public void testIsExistForEmptySimple() {
        String token = "ololo";
        HashFunc HashFunc = new SimpleHashFunc();
        Hashtable instance = new Hashtable(HashFunc);
        boolean expResult = false;
        boolean result = instance.isExist(token);
        assertEquals(expResult, result);
    }

    /**
     * Test of exist method, of class Hashtable with simple hash function if it
     * is not empty.
     */
    @Test
    public void testIsExistExistForNotEmptySimple() {
        String token = "ololo";
        HashFunc HashFunc = new SimpleHashFunc();
        Hashtable instance = new Hashtable(HashFunc);
        instance.addHT("123");
        instance.addHT(token);
        boolean expResult = true;
        boolean result = instance.isExist(token);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testReBuild() {
        Hashtable instance = new Hashtable(new SimpleHashFunc());
        instance.reBuild(new DefaultHashFunc());
        
    }
}
