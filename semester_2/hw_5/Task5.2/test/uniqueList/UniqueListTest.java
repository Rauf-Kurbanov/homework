/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uniqueList;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author paRRadox
 */
public class UniqueListTest {
    
    public UniqueListTest() {
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
     * Test of add method, of class UniqueList.
     */
    @Test
    public void testAdd() {
        UniqueList<Integer> instance = new UniqueList<>();
        instance.add(1);
        instance.add(2);
        instance.add(3);
        assertEquals("1 2 3 ", instance.print());
    }
    
    /**
     * Test of throwing exception by add method, of class UniqueList.
     */
    @Test(expected = AlreadyExistException.class)
    public void testAddException() {
        UniqueList<Integer> instance = new UniqueList<>();
        instance.add(1);
        instance.add(2);
        instance.add(2);
    }

    /**
     * Test of remove method, of class UniqueList.
     */
    @Test
    public void testRemove() {
        UniqueList<Integer> instance = new UniqueList<>();
        instance.add(1);
        instance.add(2);
        instance.add(3);
        instance.remove(2);
        assertEquals("1 3 ", instance.print());
    }
    
    /**
     * Test of throwing exception by remove method, of class UniqueList.
     */
    @Test(expected = NotExistException.class)
     public void testRemoveException() {
        UniqueList<Integer> instance = new UniqueList<>();
        instance.add(1);
        instance.add(2);
        instance.remove(3);
    }
}
