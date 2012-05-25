package parseTree;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author paRRadox
 */
public class ParseTreeTest {

    public ParseTreeTest() {
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
     * Test of print method, of class ParseTree.
     */
    @Test
    public void testPrint() {
        String str = "(* (+ 1 1) 2)";

        File file = new File("input.txt");
        try {
            file.createNewFile();
            try (BufferedWriter out = new BufferedWriter(new FileWriter("input.txt"))) {
                out.write(str);
            }
        } catch (IOException e) {
        }

        ParseTree instance = new ParseTree(file);
        System.out.println(instance.print());
        assertEquals(str, instance.print());
    }

    /**
     * Test of calculate method, of class ParseTree.
     */
    @Test
    public void testCalculate() {
        String str = "(* (+ 1 1) 2)";
        
        File file = new File("input.txt");
        try {

            file.createNewFile();
            System.out.println(file.exists());
            try (BufferedWriter out = new BufferedWriter(new FileWriter("input.txt"))) {
                out.write(str);
            }
        } catch (IOException e) {
        }

        ParseTree instance = new ParseTree(file);
        System.out.println(instance.calculate());
        assertEquals(4, instance.calculate());
    }
}
