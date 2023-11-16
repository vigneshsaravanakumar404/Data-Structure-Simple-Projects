public class BookInventorySystem{

    public static void main(String[] args) {

        System.out.print("\033[H\033[2J");  

        
        // Create a BookOrderProcessor
        BookOrderProcessor orderProcessor = new BookOrderProcessor();

        // Enqueue book orders
        orderProcessor.enqueueOrder(new BookOrder("Java Programming", 5));
        orderProcessor.enqueueOrder(new BookOrder("Data Structures", 3));
        orderProcessor.enqueueOrder(new BookOrder("Algorithms", 7));
        orderProcessor.enqueueOrder(new BookOrder("Queue Do you Think you Are?", 12));

        // Display total orders in System
        System.out.println("Total orders in System: " + orderProcessor.getTotalOrders());

        // Process book orders
        orderProcessor.processOrders();

        // Display total orders remaining
        System.out.println("Total orders remaining: " + orderProcessor.getTotalOrders());
    }
}
