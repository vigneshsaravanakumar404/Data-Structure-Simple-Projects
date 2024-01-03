import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class BookOrderProcessor {
    private Queue<BookOrder> orderQueue;
    private Queue<BookOrder> priorityQueue;

    public BookOrderProcessor() {
        this.orderQueue = new LinkedList<BookOrder>();
        this.priorityQueue = new PriorityQueue<BookOrder>(3, new BookOrderComparator());
    }

    public void enqueueOrder(BookOrder order) {
        orderQueue.add(order);
        priorityQueue.add(order);

    }

    public void processOrders() {
        while (!orderQueue.isEmpty()) {
            BookOrder order = orderQueue.remove();
            System.out.println(order);
        }
    }

    public void processOrdersPriority() {
        while (!priorityQueue.isEmpty()) {
            BookOrder order = priorityQueue.remove();
            System.out.println(order);
        }
    }

    public int getTotalOrders() {
        return orderQueue.size();
    }
}
