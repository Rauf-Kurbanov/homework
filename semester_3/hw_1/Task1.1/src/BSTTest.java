import java.util.Iterator;
import org.junit.*;
import static org.junit.Assert.*;

public class BSTTest {

    public BSTTest() {
        instance = new BST();
    }

    @After
    public void tearDown() {
        instance.clear();
    }

    public void setUpByNums() {
        instance.add(5, "five");
        instance.add(2, "two");
        instance.add(2, "two");
        instance.add(8, "eight");
        instance.add(9, "nine");
        instance.add(0, "zero");
    }

    @Test
    public void testAdd() {
        instance.add(5, "your");
        instance.add(2, "Who's");
        instance.add(8, "Daddy?");

        assertEquals("Who's your Daddy? ", instance.print());
    }

    @Test
    public void testSearch() {
        setUpByNums();
        assertEquals("eight", instance.search(8));
    }

    @Test
    public void testForeach() {
        setUpByNums();
        Iterator it = instance.iterator();
        String output = "";
        for (String str : instance) {
            output += str + " ";
        }
        assertEquals(output, instance.print());
    }

    @Test
    public void testRemove() {
        instance.add(5, "Monkeys?");
        instance.add(4, "Arctic");
        instance.add(3, "are");
        instance.add(2, "fuck");
        instance.add(1, "the");
        instance.add(0, "Who");

        Iterator it = instance.iterator();
        it.next();
        it.next();
        it.remove();
        it.next();
        it.remove();

        String censored = "Who are Arctic Monkeys? ";
        assertEquals(censored, instance.print());
    }

    private BST<Integer, String> instance;
}