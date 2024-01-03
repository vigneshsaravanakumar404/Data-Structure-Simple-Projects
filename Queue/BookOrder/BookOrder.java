public class BookOrder {

    private String bookTitle;
    private int quantity;

    public BookOrder(String bookTitle, int quantity) {
        this.bookTitle = bookTitle;
        this.quantity = quantity;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public int getQuantity() {
        return quantity;
    }

    public String toString() {
        return bookTitle + " " + quantity;
    }
}