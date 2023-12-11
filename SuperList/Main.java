public class Main {
    
    public static void main(String[] args) {
        SuperList<Integer> superList = new SuperList<>();

        // Test adding elements
        superList.add(1);
        superList.add(2);
        superList.add(3);
        superList.add(4);

        // Test toString method
        System.out.println("List contents: " + superList.toString()); // Expected: [1, 2, 3, 4]
        System.out.println("List size: " + superList.size()); // Expected: 4
    }
}