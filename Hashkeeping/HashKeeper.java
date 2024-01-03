package Hashkeeping;

public class HashKeeper<E> {

    private Object[] table;
    private int size;
    public static final double LOAD_FACTOR = 0.75;

    public HashKeeper(int capacity) {
        table = new Object[capacity];
        size = 0;
    }

    private int hashToIndex(E val) {
        return Math.abs(val.hashCode()) % table.length;
    }

    public boolean contains(E val) {
        if (null == table[hashToIndex(val)]) {
            return false;
        }
        return true;
    }

    public E remove(E val) {
        if (contains(val)) {
            table[hashToIndex(val)] = null;
            size--;
            return val;
        }
        return null;
    }

    public void add(E val) {
        table[hashToIndex(val)] = val;
        size++;
    }

    public void printBuckets() {
        System.out.print("[");
        if (size == 0) {
            System.out.print("]");
            return;
        }
        for (int i = 0; i < table.length - 1; i++) {
            System.out.print("\"" + table[i] + "\", ");
        }
        System.out.print("\"" + table[table.length - 1] + "\"]\n");
    }

    public static void main(String[] args) {
        HashKeeper<String> hk = new HashKeeper<>(6);
        hk.add("Keys");
        hk.add("Wallet");
        hk.add("Glasses");
        hk.printBuckets();
        System.out.println(hk.contains("Glasses"));
        System.out.println(hk.remove("Glasses"));
        System.out.println(hk.contains("Glasses"));
    }
}