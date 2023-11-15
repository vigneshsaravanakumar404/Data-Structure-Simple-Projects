import java.util.Queue;
import java.util.LinkedList;

public class BookOrderProcessor {
    private Queue<BookOrder> orderQueue;

    public BookOrderProcessor() {
        this.orderQueue = new LinkedList<BookOrder>();
    }

    public void enqueueOrder(BookOrder order) {
        orderQueue.add(order);
    }

    public void processOrders() {
        while (!orderQueue.isEmpty()) {
            BookOrder order = orderQueue.remove();
            System.out.println(order);
        }
    }

    public int getTotalOrders(){
        return orderQueue.size();
    }
}
