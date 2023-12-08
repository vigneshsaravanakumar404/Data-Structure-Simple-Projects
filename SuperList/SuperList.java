package SuperList;

public class SuperList<T> {

    private T element;
    private ListNode<T> root;
    private ListNode<T> end;
    private int size;

    // Ask if you need an array to keep track of the elements

    public SuperList(T element){
        this.element = element;
        this.root = new ListNode<T>(element);
        this.end = this.root;
        this.size = 0;
    }

    
}
