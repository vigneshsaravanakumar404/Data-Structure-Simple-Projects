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

    public int size() {
        return size;
    }

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
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        ListNode<T> temp = new ListNode<>(value);
        if (index == 0) {
            temp.setNext(root);
            root.setPrev(temp);
            root = temp;
        } else if (index == size) {
            end.setNext(temp);
            temp.setPrev(end);
            end = temp;
        } else {
            ListNode<T> current = root;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            temp.setNext(current.getNext());
            temp.setPrev(current);
            current.setNext(temp);
            temp.getNext().setPrev(temp);
        }
        size++;
    }

    public T remove(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T result = null;
        if (index == 0) {
            result = root.getElement();
            root = root.getNext();
            root.setPrev(null);
        } else if (index == size - 1) {
            result = end.getElement();
            end = end.getPrev();
            end.setNext(null);
        } else {
            ListNode<T> current = root;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            result = current.getNext().getElement();
            current.setNext(current.getNext().getNext());
            current.getNext().setPrev(current);
        }
        size--;
        return result;
    }

    public void clear(){
        root = null;
        end = null;
        size = 0;
    }

    public String toString() {
        String result = "[";
        ListNode<T> temp = root;
        while (temp != null) {
            result += temp.getElement().toString();
            if (temp.hasNext()) {
                result += ", ";
            }
            temp = temp.getNext();
        }
        result += "]";
        return result;
    }

    public boolean contains(T value) {
        ListNode<T> temp = root;
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
}
