public class Main {

    public static void main(String[] args) {

        String long_number_1 = "12345678901234567890123456789012345678901234567890123456789012345678901234567890";
        String long_number_2 = "12345678901234567890123456789012345678901234567890123456789012345678901234567890";

        BigIntegerMath bigIntegerMath = new BigIntegerMath(long_number_1, long_number_2);
        System.out.println(bigIntegerMath.sum());

    }
}
