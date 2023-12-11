package SuperList;
public class ListNode<T> {
    
    private T element;
    private ListNode<T> next;
    private ListNode<T> prev;

    public ListNode(T element) {
        this.element = element;
        this.next = null;
        this.prev = null;
    }

    public void setPrev(ListNode<T> prev) {
        this.prev = prev;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    public ListNode<T> getNext() {
        return this.next;
    }

    public ListNode<T> getPrev() {
        return this.prev;
    }

    public T getElement() {
        return element;
    }

    public boolean hasNext() {
        return this.next != null;
    }

    public boolean hasPrev() {
        return this.prev != null;
    }

}
