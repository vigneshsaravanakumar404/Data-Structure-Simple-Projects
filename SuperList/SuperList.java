package SuperList;

public class SuperList<T> {

    private T element;
    private ListNode<T> root;
    private ListNode<T> end;
    private int size;
    private ListNode<T>[] elements;


    public SuperList(T element){
        this.element = element;
        this.root = new ListNode<T>(element);
        this.end = this.root;
        this.size = 0;
        this.elements = new ListNode[1000]; // 1000 is arbitrary
    }

    // TODO: Check to make sure it is in size
    public void add(T element){
        elements[size] = new ListNode<T>(element);
        this.size++;
    }

    public int size(){
        return this.size;
    }

    public String toString(){
        String output = "[";
        for (int i = 0; i < this.size; i++){
            output += elements[i].getVal() + ", ";
        }
        return output + "]";
    }

    // TODO: Write unit test
    
}
