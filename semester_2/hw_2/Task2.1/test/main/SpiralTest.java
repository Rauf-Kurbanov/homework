package main;

import static org.junit.Assert.assertEquals;
import org.junit.*;

/**
 *
 * @author paRRadox
 */
public class SpiralTest {
    
    public SpiralTest() {
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
     * Test of matrixToLine method, of class Spiral.
     */
    @Test
    public void testMatrixToLine() {
        Integer[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        String expResult = "536987412";
        String result = Spiral.matrixToLine(array);
        assertEquals(expResult, result);
    }
}
