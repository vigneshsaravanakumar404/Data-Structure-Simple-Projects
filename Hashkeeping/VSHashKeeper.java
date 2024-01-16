// package Hashkeeping;

public class VSHashKeeper<E> {

    public Object[] table;
    private int size = 0;
    public static final double LOAD_FACTOR = 0.75; // resize when size is .75 capacity
    public final Object TOMB_STONE = new Object();

    public VSHashKeeper(int capacity) {
        table = new Object[capacity];
        size = 0;
    }

    private int hashToIndex(E val) {
        return Math.abs(val.hashCode()) % table.length;
    }

    public void add(E val) {
        if (val == "") {
            return;
        }
        if (contains(val)) {
            return;
        }
        if (size >= table.length * LOAD_FACTOR) {
            rehash();
        }
        int index = hashToIndex(val);
        while (table[index] != null && table[index] != TOMB_STONE) {
            index++;
            if (index == table.length) {
                index = 0;
            }
        }
        table[index] = val;
        size++;
    }

    public boolean contains(E val) {
        int index = hashToIndex(val);
        while (table[index] != null) {
            if (table[index].equals(val)) {
                return true;
            }
            index++;
            if (index == table.length) {
                index = 0;
            }
        }
        return false;
    }

    public boolean remove(E val) {
        int index = hashToIndex(val);
        while (table[index] != null) {
            if (table[index].equals(val)) {
                table[index] = new Object(); // Tombstone
                size--;
                return true;
            }
            index++;
            if (index == table.length) {
                index = 0;
            }
        }
        return false;
    }

    private void rehash() {
        Object[] oldTable = table;
        table = new Object[2 * oldTable.length];
        size = 0;
        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] != null && oldTable[i] != TOMB_STONE) {
                add((E) oldTable[i]);
            }
        }
    }

    public void printBuckets() {
        System.out.println();
        if (size == 0) {
            System.out.print("[]");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < table.length - 1; i++) {
            System.out.print(table[i] + ", ");
        }
        System.out.print(table[table.length - 1] + "]");
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && table[i] != TOMB_STONE) {
                result += table[i] + " ";
            }
        }
        return result;
    }

    public String size() {
        return String.valueOf(size);
    }
}