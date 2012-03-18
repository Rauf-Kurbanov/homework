package main;

import static org.junit.Assert.assertEquals;
import org.junit.*;

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
     * Test of addHT method, of class Hashtable.
     */
    @Test
    public void testAddHT() {
        String token = "Test";
        Hashtable instance = new Hashtable();
        instance.addHT("ololo");
        instance.addHT(token);
        assertEquals(true, instance.isExist(token));
    }

    /**
     * Test of exist method, of class Hashtable if it is empty.
     */
    @Test
    public void testIsExistForEmpty() {
        String token = "ololo";
        Hashtable instance = new Hashtable();
        //instance.addHT("123");
        System.out.println(instance.hashFunc(token));
        boolean expResult = false;
        boolean result = instance.isExist(token);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of exist method, of class Hashtable if it is not empty.
     */
    @Test
    public void testIsExistExistForNotEmpty() {
        String token = "ololo";
        Hashtable instance = new Hashtable();
        instance.addHT("123");
        instance.addHT(token);
        System.out.println(instance.hashFunc(token));
        boolean expResult = true;
        boolean result = instance.isExist(token);
        assertEquals(expResult, result);
    }
  
    /**
     * Test of HashFunc method, of class Hashtable.
     */
    @Test
    public void testHashFunc() {
        String token = "ololo123";
        Hashtable instance = new Hashtable(10);
        int expResult = token.hashCode() % 10;
        int result = instance.hashFunc(token);
        assertEquals(expResult, result);
        System.out.println(instance.hashFunc(token));
    }
    
    /**
     * Test of size method, of class Hashtable.
     */
    @Test 
    public void testSize() {
        int expSize = 50;
        Hashtable instance = new Hashtable(expSize);
        assertEquals(expSize, instance.size());
    }
}
