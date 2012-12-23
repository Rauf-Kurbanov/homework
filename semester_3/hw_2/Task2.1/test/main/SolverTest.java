/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.*;

/**
 *
 * @author Maestro
 */
public class SolverTest {
    
    public SolverTest() {
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
     * Test of haveSolution method, of class Solver.
     */
    @Test
    public void testHaveSolution() {
        byte[][] graph = {
            {0, 0, 1, 0, 0, 0},
            {0, 0, 1, 0, 0, 0},
            {1, 1, 0, 1, 0, 0},
            {0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0}
        };
        byte[] robots = {1, 1, 0, 0, 0, 1};
        
        Solver solver = new Solver(graph, robots);
        assertTrue(solver.haveSolution());
    }

    /**
     * Test of haveSolution method, of class Solver.
     */
    @Test
    public void testHaveNoSolution() {
        byte[][] graph = {
            {0, 1, 0},
            {1, 0, 1},
            {0, 1, 0}
        };
        byte[] robots = {1, 1, 0};
        
        Solver solver = new Solver(graph, robots);
        assertFalse(solver.haveSolution());
    }
}
