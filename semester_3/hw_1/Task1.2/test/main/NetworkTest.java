package main;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Maestro
 */
public class NetworkTest {
    
    public NetworkTest() {
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

    @Test
    public void testNetwork() {
        byte[][] connections = {
            {0, 0, 0, 1, 0, 0, 0, 0, 1},
            {0, 0, 1, 1, 1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0, 0},
            {1, 1, 0, 0, 1, 0, 0, 1, 1},
            {0, 1, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 0, 0},
            {1, 0, 0, 1, 0, 0, 1, 0, 0}
        };        
        Computer[] users = new Computer[9];
        users[0] = new Computer(new TestOS(), true);
        users[1] = new Computer(new TestOS(), false);
        users[2] = new Computer(new TestOS(), false);
        users[3] = new Computer(new TestOS(), false);
        users[4] = new Computer(new TestOS(), false);
        users[5] = new Computer(new TestOS(), false);
        users[6] = new Computer(new TestOS(), false);
        users[7] = new Computer(new TestOS(), false);
        users[8] = new Computer(new TestOS(), true);
        
        Network network = new Network(connections, users);
        network.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(NetworkTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals("55% infected", network.printState());
    }
    
    public class TestOS extends OS {
        
        public TestOS() {
            this.virusProb = 100;
        }
    }
    
    public class TestComputer extends Computer {

        public TestComputer(OS os, boolean isInfected) {
            super(os, isInfected);
        }

        @Override
        public void attack(Computer aim) {
            if (isInfected() && 50 < aim.os.getProb()) {
                aim.infect();
            }
        }
    }
}
