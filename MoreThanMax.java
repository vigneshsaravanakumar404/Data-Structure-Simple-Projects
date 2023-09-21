public class MoreThanMax {

    public static void main(String[] args) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        System.out.println("\nMin-1\t\tMax+1");
        System.out.println(safeAdd(max, min) + "\t");

    }

    public static int safeAdd(int a, int b) {

        if (a > 0 && b > 0 && a > Integer.MAX_VALUE - b) {
            throw new ArithmeticException("Integer Overflow");
        }
        if (a < 0 && b < 0 && a < Integer.MIN_VALUE - b) {
            throw new ArithmeticException("Integer Underflow");
        } else {
            return a + b;
        }
    }

}