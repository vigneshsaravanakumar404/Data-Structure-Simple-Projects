import org.junit.Test;
import java.util.EmptyStackException;
import static org.junit.Assert.*;

public class UnitTests {

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
        list.add(0, 100); // Add 100 to the start
        list.add(5, 101); // Add 101 to the end
        list.add(3, 103); // Add 103 to the middle
        assertEquals("[100, 1, 2, 103, 3, 4, 101]", list.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtInvalidIndex() {
        SuperList<Integer> list = new SuperList<>();
        list.add(1);
        list.add(2);

        // Test the Error
        list.add(10, 100);
    }


    @Test
    public void Clear(){
        SuperList<Integer> list = new SuperList<>();
        list.add(1); // 0
        list.add(2); // 1
        list.add(3); // 2
        list.add(4); // 3
        list.add(0, 100); // Add 100 to the start
        list.add(5, 101); // Add 101 to the end
        list.add(3, 103); // Add 103 to the middle
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

    @Test
    public void get(){
        SuperList<Integer> list = new SuperList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(1, (int)list.get(0));
        assertEquals(2, (int)list.get(1));
        assertEquals(3, (int)list.get(2));
        assertEquals(1, (int)list.queuePeek());
        assertEquals(3, (int)list.stackPeek());
        list.remove(0);
        list.remove(0);
        list.remove(0);
        assertEquals(null, list.queuePeek());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getInvalidIndex() {
        SuperList<Integer> list = new SuperList<>();
        list.add(1);
        list.add(2);

        // Test the Error
        list.get(10);
    }

    @Test
    public void set(){
        SuperList<Integer> list = new SuperList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.set(100, 0);
        list.set(200, 1);
        list.set(300, 2);
        assertEquals("[100, 200, 300]", list.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setInvalidIndex() {
        SuperList<Integer> list = new SuperList<>();
        list.add(1);
        list.add(2);

        // Test the Error
        list.set(10, 100);
    }

    // Suggested Test Cases
    @Test(expected = EmptyStackException.class)
    public void test_as_a_stack(){
        SuperList<Integer> stack = new SuperList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.size());
        assertEquals("[1, 2, 3]", stack.toString());
        assertEquals(3, (int)stack.stackPeek());
        assertEquals(3, (int)stack.pop());
        assertEquals(2, (int)stack.pop());
        assertEquals(1, (int)stack.pop());        
        assertEquals(0, stack.size());
        assertEquals(true, stack.isEmpty());
        stack.pop();
    }

    // Test as a queue
    @Test
    public void test_as_a_queue(){
        SuperList<Integer> queue = new SuperList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        assertEquals(3, queue.size());
        assertEquals("[1, 2, 3]", queue.toString());
        assertEquals(1, (int)queue.queuePeek());
        assertEquals(1, (int)queue.poll());
        assertEquals(2, (int)queue.poll());
        assertEquals(3, (int)queue.poll());        
        assertEquals(0, queue.size());
        assertEquals(true, queue.isEmpty());
        assertEquals(null, queue.poll());
    }

    // Test as arraylist
    @Test 
    public void test_as_arraylist(){
        SuperList<Integer> list = new SuperList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
        assertEquals("[1, 2, 3]", list.toString());
        assertEquals(1, (int)list.get(0));
        assertEquals(2, (int)list.get(1));
        assertEquals(3, (int)list.get(2));
        list.set(100, 0);
        list.set(200, 1);
        list.set(300, 2);
        assertEquals("[100, 200, 300]", list.toString());
        list.remove(0);
        list.remove(0);
        list.remove(0);
        assertEquals("[]", list.toString());
        assertEquals(0, list.size());
        assertEquals(true, list.isEmpty());
        assertEquals("[]", list.toString());
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(0, 100); // Add 100 to the start
        assertEquals("[100, 1, 2, 3]", list.toString());
        try {
            list.remove(10);
            fail("Should have thrown an exception");
        } catch (IndexOutOfBoundsException e) {
            
        }
        assertEquals(4, list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_as_arraylist_errors(){
        SuperList<Integer> list = new SuperList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.get(10);
        list.set(10, 100);
        list.remove(10);
    }

    @Test
    public void testStackPushPeekSize() {
        SuperList<Integer> stack = new SuperList<>();
        for (int i = 5; i <= 10; i++) {
            stack.push(i);
        }
        assertEquals("[5, 6, 7, 8, 9, 10]", stack.toString());
        assertEquals(10, (int) stack.stackPeek());
        assertEquals(6, stack.size());
    }

    @Test
    public void testStackPop() {
        SuperList<Integer> stack = new SuperList<>();
        for (int i = 5; i <= 10; i++) {
            stack.push(i);
        }
        assertEquals(10, (int) stack.pop());
        assertEquals(5, stack.size());
        assertEquals("[5, 6, 7, 8, 9]", stack.toString());
    }

    @Test
    public void testStackPopUntilEmpty() {
        SuperList<Integer> stack = new SuperList<>();
        for (int i = 5; i <= 10; i++) {
            stack.push(i);
        }
        StringBuilder poppedElements = new StringBuilder();
        while (!stack.isEmpty()) {
            poppedElements.append(stack.pop()).append(" ");
        }
        assertEquals("10 9 8 7 6 5", poppedElements.toString().trim());
}


    @Test(expected = java.util.EmptyStackException.class)
    public void testPopOnEmptyStack() {
        SuperList<Integer> stack = new SuperList<>();
        stack.pop();
    }

    @Test(expected = java.util.EmptyStackException.class)
    public void testPeekOnEmptyStack() {
        SuperList<Integer> stack = new SuperList<>();
        stack.stackPeek();
    }

    @Test
    public void testStackClearAndOperations() {
        SuperList<Integer> stack = new SuperList<>();
        stack.push(5);
        stack.clear();
        try {
            stack.pop();
            fail("Should have thrown java.util.EmptyStackException");
        } catch (java.util.EmptyStackException e) {
            // Expected exception
        }
    }

    
}