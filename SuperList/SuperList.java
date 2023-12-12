import java.util.EmptyStackException;


public class SuperList<T> {
    public class ListNode<E> {
    
        private E element;
        private ListNode<E> prev;
        private ListNode<E> next;
    
        public ListNode(E element) {
            this.element = element;
            this.next = null;
            this.prev = null;
        }
    
        public void setPrev(ListNode<E> prev) {
            this.prev = prev;
        }
    
        public void setNext(ListNode<E> next) {
            this.next = next;
        }
    
        public ListNode<E> getNext() {
            return this.next;
        }
    
        public ListNode<E> getPrev() {
            return this.prev;
        }
    
        public E getElement() {
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

    // Constructor
    public SuperList() {
        root = null;
        end = null;
        size = 0;
    }

    // Getters
    public int size() {
        return size;
    }

    public void clear(){
        root = null;
        end = null;
        size = 0;
    }

    public boolean contains(T value) {
        ListNode<T> temp = root;

        // Go through each element until you reach null or get to the element
        while (temp != null) {
            if (temp.getElement().equals(value)) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }

    // Add
    public void add(T object) {
        ListNode<T> temp = new ListNode<>(object);
        if (root == null) {
            root = temp;
            end = temp;
        } else {
            end.setNext(temp);
            temp.setPrev(end);
            end = temp;
        }
        size++;
    }

    public void add(T value, int index){
        
        // Check if the requested add location is out of size
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        // Create tempary holding space for the value to be added
        ListNode<T> temp = new ListNode<>(value);

        /*
         * if adding at the start then: 
         * set the next node to the root node
         * set previous node to the value being added
         */
        if (index == 0) {
            temp.setNext(root);
            root.setPrev(temp);
            root = temp;
        } 
        
        /*
         * If you are adding at the end then:
         * set next node to value being added
         * set previous nodes to the already existing nodes (root)
         */
        else if (index == size) {
            end.setNext(temp);
            temp.setPrev(end);
            end = temp;
        } 
        
        /*
        * If you are adding somewhere in the middle:
        * Start at the root and move forward until you reach the position just before where you want to add the new node.
        * Set the next node of the new node (temp) to be the current node's next node. This links the new node to the part of the list that comes after it.
        * Set the previous node of temp to be the current node. This links the new node to the part of the list that comes before it.
        * Update the current node's next node to be temp. This officially inserts the new node into the list at the correct position.
        * Finally, make sure the node right after temp links back to temp as its previous node, maintaining the two-way link of the list.
        */
        else {
            ListNode<T> current = root;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            temp.setNext(current.getNext());
            temp.setPrev(current);
            current.setNext(temp);
            temp.getNext().setPrev(temp);
        }

        // Increase the size
        size++;
    
    }

    public void push(T object){
        add(object);
    }

    // Remove
    public T remove(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T result = null;

        /*
         * if removing from the start:
         * get the element at the removal spot
         * set root to be all the nodes after the removal element
         * set the previous to null to show its the start of the nodes
         */
        if (index == 0) {
            result = root.getElement();
            root = root.getNext();
            if (root != null) {
                root.setPrev(null);
            }
        }
        
        
        /*
         * if removing from the end:
         * get the element at the removal spot
         * set the root to be all the nodes before the removal element
         * set the next to null to show its the end of the nodes
         */
        else if (index == size - 1) {
            result = end.getElement();
            end = end.getPrev();
            end.setNext(null);
        } 
        
        /*
         * if removing elsewhere:
         * create a temp copy of the nodes
         * make the temp copy all the elements after the removal element
         * get the elemenet at the removal spot
         * set the temp nodes to all the elements after the removal element
         * set the previous nodes to all elements before the removal element
         */
        else {
            ListNode<T> current = root;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            result = current.getNext().getElement();
            current.setNext(current.getNext().getNext());
            current.getNext().setPrev(current);
        }

        // Decrease the size & return the result
        size--;
        return result;
    }

    public T pop(){
        if (isEmpty()) {
            throw new EmptyStackException();

        }
        return remove(size - 1);
    }

    public T poll(){
        if (isEmpty()){
            return null;
        }
        else{
            return remove(0);
        }
    }

    // Get
    public T get(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T result;
        if (index == 0) {
            result = root.getElement();
        } else if (index == size - 1) {
            result = end.getElement();
        } else {
            ListNode<T> current = root;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            result = current.getNext().getElement();
        }

        return result;
    }

    public T stackPeek(){
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return get(size - 1);
    }

    public T queuePeek(){
        if (isEmpty()) {
            return null;
        }
        return get(0);
    }

    // Set
    public T set(T object, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T result;
    
        if (index == 0) {
            result = root.getElement();
            ListNode<T> temp = new ListNode<>(object);
            temp.setNext(root.getNext());
            if (temp.getNext() != null) {
                temp.getNext().setPrev(temp);
            }
            root = temp;
        } else if (index == size - 1) {
            result = end.getElement();
            ListNode<T> temp = new ListNode<>(object);
            temp.setPrev(end.getPrev());
            if (temp.getPrev() != null) {
                temp.getPrev().setNext(temp);
            }
            end = temp;
        } else {
            ListNode<T> current = root;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            result = current.getNext().getElement();
            ListNode<T> temp = new ListNode<>(object);
            temp.setNext(current.getNext().getNext());
            temp.setPrev(current);
            current.setNext(temp);
            if (temp.getNext() != null) {
                temp.getNext().setPrev(temp);
            }
        }
    
        return result;
    }
    
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        ListNode<T> temp = root;
        while (temp != null) {
            result.append(temp.getElement().toString());
            if (temp.hasNext()) {
                result.append(", ");
            }
            temp = temp.getNext();
        }
        result.append("]");
        return result.toString();
    }
}
