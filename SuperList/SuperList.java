package SuperList;

public class SuperList<T> {
    public class ListNode<T> {
    
        private T element;
        private ListNode<T> prev;
        private ListNode<T> next;
    
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

    
    private ListNode<T> root;
    private ListNode<T> end;
    private int size;


    public SuperList() {
        root = null;
        end = null;
        size = 0;
    }
    
}
