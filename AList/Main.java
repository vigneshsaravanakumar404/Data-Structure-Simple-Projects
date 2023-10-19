public class Main {

    public static void main(String[] args) {
        AList al = new AList();
        al.add("apple");
        al.add("banana");
        al.add("cherry");
        System.out.println(al);
        al.add("durian");
        al.add("elderberry");
        System.out.println(al);
        al.remove(2);
        System.out.println(al);
        System.out.println("Contains peach = " + al.contains("peach"));
        System.out.println("Contains apple = " + al.contains("apple"));

        try {
            al.remove(6);
        } catch (Exception e) {
            System.out.println("Remove not possible, caught => " + e);
        }
        System.out.println(al);
        System.out.println(al.remove(2));
        al.add(1, "apricot");
        System.out.println(al);

        // Int Type
        System.out.println("\n\nInt");
        AList<Integer> intList = new AList<>();
        intList.add(1);
        intList.add(2);
        System.out.println(intList);

        // Double Type
        System.out.println("\n\nDouble");
        AList<Double> doubleList = new AList<>();
        doubleList.add(10.0);
        doubleList.add(5.5);
        System.out.println(doubleList);

        // Create a new AList of Integer type
        AList<Integer> list = new AList<>();

        // Add some elements to the list
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // Test indexOf() method
        System.out.println("Index of 3: " + list.indexOf(3)); // Should print 2
        System.out.println("Index of 6: " + list.indexOf(6)); // Should print -1

        // Test remove(Object o) method
        list.remove((Object) 3);
        System.out.println("List after removal: " + list.toString()); // Should print [1, 2, 4, 5]
        list.remove((Object) 6);
        System.out.println("List after removal: " + list.toString()); // Should print [1, 2, 4, 5]

        // Print the list to verify
        System.out.println("List after removal: " + list.toString()); // Should print [1, 2, 4, 5]

    }
}