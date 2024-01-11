package Hashkeeping;

public class HashKeeper<E> {

    private Object[] table;
    private int size;
    public static final double LOAD_FACTOR = 0.75;
    public static final Object TOMBSTON_OBJECT = new Object();

    public HashKeeper(int capacity) {
        table = new Object[capacity];
        size = 0;
    }

    private int hashToIndex(E val) {
        return Math.abs(val.hashCode()) % table.length;
    }

    public boolean contains(E val) {
        int startIndex = hashToIndex(val);
        for (int i = startIndex; i < table.length; i++) {
            if (table[i] == null) {
                return false;
            } else if (table[i].equals(val)) {
                return true;
            }
            if (i == table.length - 1) {
                i = -1; 
            }
            if (i == startIndex - 1) {
                return false;
            }
        }
        return false;
    }

    public boolean remove(E val) {
        int index = hashToIndex(val);
        if (table[index] != null && table[index].equals(val)) {
            table[index] = null;
            size--;
            return true;
        } else {
            int i = index;
            do {
                i = (i + 1) % table.length;
                if (table[i] != null && table[i].equals(val)) {
                    table[i] = null;
                    size--;
                    return true;
                }
            } while (i != index);
        }
        return false;
    }

    private <T> void rehash() {
        System.out.println("Size" + size + "REHASHING");
        int newCapacity = table.length * 2;
        Object[] oldTable = table;
        table = new Object[newCapacity];

        
        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] != null && oldTable[i] != TOMBSTON_OBJECT) {
                add((E) oldTable[i]);
            }
        }

        size = 0;
    }

    public void add(E val) {

        if (size == table.length * LOAD_FACTOR) {
            rehash();
        }

        int index = hashToIndex(val);

        if (table[index] == null) {
            table[index] = val;
            size++;
        } else {
            int i = index;
            do {
                i = (i + 1) % table.length;
            } while (table[i] != null);
            table[i] = val;
            size++;
        }

    }


    public void printBuckets() {
        String s = "";
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                s += table[i] + " ";
            }
        }
        System.out.println(s);
    }

    public String toString() {
        String s = "[";
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                s += table[i] + ", ";
            }
        }
        if (s.length() > 1) {
            s = s.substring(0, s.length() - 2);
        }
        s += "]";
        return s;
    }
}