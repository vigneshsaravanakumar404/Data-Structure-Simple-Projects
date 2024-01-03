import java.util.Comparator;

public class BookOrderComparator implements Comparator<BookOrder> {

    @Override
    public int compare(BookOrder o1, BookOrder o2) {
        return o2.getQuantity() - o1.getQuantity();
    }

}
