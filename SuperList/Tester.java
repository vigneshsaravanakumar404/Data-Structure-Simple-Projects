import org.junit.Test;
import java.util.EmptyStackException;
import static org.junit.Assert.*;

public class Tester {

    @Test
    public void AddAndSize() {
        SuperList<Integer> list = new SuperList<>();
        assertEquals(0, list.size());

        list.add(1);
        assertEquals(1, list.size());

        list.add(2);
        assertEquals(2, list.size());
    }

    @Test
    public void ToString() {
        SuperList<Integer> list = new SuperList<>();
        assertEquals("[]", list.toString()); // Empty list should return "[]"

        list.add(1);
        assertEquals("[1]", list.toString()); // List with one element

        list.add(2);
        assertEquals("[1, 2]", list.toString()); // List with two elements
    }

    @Test
    public void Add(){
        SuperList<Integer> list = new SuperList<>();
        list.add(1); // 0
        list.add(2); // 1
        list.add(3); // 2
        list.add(4); // 3
        list.add(100, 0); // Add 100 to the start
        list.add(101, 5); // Add 101 to the end
        list.add(103, 3); // Add 103 to the middle
        assertEquals("[100, 1, 2, 103, 3, 4, 101]", list.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtInvalidIndex() {
        SuperList<Integer> list = new SuperList<>();
        list.add(1);
        list.add(2);

        // Test the Error
        list.add(100, 10);
    }


    @Test
    public void Clear(){
        SuperList<Integer> list = new SuperList<>();
        list.add(1); // 0
        list.add(2); // 1
        list.add(3); // 2
        list.add(4); // 3
        list.add(100, 0); // Add 100 to the start
        list.add(101, 5); // Add 101 to the end
        list.add(103, 3); // Add 103 to the middle
        list.clear();
        assertEquals("[]", list.toString());
    }

    @Test
    public void contains(){
        SuperList<Integer> list = new SuperList<>();
        list.add(1); // 0
        list.add(2); // 1
        list.add(3); // 2
        list.add(4); // 3
        assertEquals(list.contains(4), true);
        list.clear();
        assertEquals(list.contains(4), false);
    }

    @Test
    public void remove(){
        SuperList<Integer> list = new SuperList<>();
        list.add(1); // 0
        list.add(2); // 1
        list.add(3); // 2
        list.add(4); // 3
        list.add(5); // 4
        list.remove(list.size() - 1);
        assertEquals("[1, 2, 3, 4]", list.toString());
        list.remove(2);
        assertEquals("[1, 2, 4]", list.toString());
        list.remove(0);
        assertEquals("[2, 4]", list.toString());
        list.remove(0);
        assertEquals("[4]", list.toString());
        list.remove(0);
        assertEquals("[]", list.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeAtInvalidIndex() {
        SuperList<Integer> list = new SuperList<>();
        list.add(1);
        list.add(2);

        // Test the Error
        list.remove(10);
    }

    @Test
    public void pop(){
        SuperList<Integer> list = new SuperList<>();
        list.add(1);
        list.add(2);

        assertEquals(2, (int)list.pop());
    }

    @Test(expected = EmptyStackException.class)
    public void popEmpty(){
        SuperList<Integer> list = new SuperList<>();
        list.pop();
    }

    @Test
    public void poll(){
        SuperList<Integer> list = new SuperList<>();
        list.add(1);

        assertEquals(1, (int)list.poll());
        assertEquals(null, list.poll());
    }

    @Test
    public void isEmpty(){
        SuperList<Integer> list = new SuperList<>();
        assertEquals(true, list.isEmpty());
        list.add(1);
        assertEquals(false, list.isEmpty());
    }

    @Test
    public void push(){
        SuperList<Integer> list = new SuperList<>();
        list.push(1);
        list.push(2);
        assertEquals("[1, 2]", list.toString());
    }

}