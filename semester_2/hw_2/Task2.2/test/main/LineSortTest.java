/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Maestro
 */
public class LineSortTest {

    public LineSortTest() {
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
     * Test of columnSwap method, of class LineSort.
     */
    @Test
    public void testColumnSwap() {
        int[][] arr = {{1, 2}, {1, 2}};
        int i = 0;
        int j = 1;
        LineSort.columnSwap(arr, i, j);
        int[][] expArr = {{2, 1}, {2, 1}};
        Assert.assertEquals(expArr, arr);
    }

    /**
     * Test of Sort method, of class LineSort.
     */
    @Test
    public void testSort() {
        int[][] array = {{5, 6, 4}, {1, 2, 3}, {7, 8, 9}};
        LineSort.sort(array);
        int[][] expArray = {{4, 5, 6}, {3, 1, 2}, {9, 7, 8}};
        Assert.assertEquals(expArray, array);
    }
}
