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
    }
}