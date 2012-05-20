package main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
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
        assertTrue(instance.isExist(token));
    }

    /**
     * Test of exist method, of class Hashtable if it is empty.
     */
    @Test
    public void testIsExistForEmpty() {
        String token = "ololo";
        Hashtable instance = new Hashtable();
        assertFalse(instance.isExist(token));
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
        assertTrue(instance.isExist(token));
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
