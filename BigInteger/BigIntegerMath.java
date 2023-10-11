public class BigIntegerMath {

    // Strings
    String n1;
    String n2;

    // Constructor
    public BigIntegerMath(String n1, String n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    public String sum() {

        String[] long_number_1_segments = n1.split("(?<=\\G.{15})");
        String[] long_number_2_segments = n2.split("(?<=\\G.{15})");

        long[] long_number_1_segments_int = new long[long_number_1_segments.length];
        long[] long_number_2_segments_int = new long[long_number_2_segments.length];

        for (int i = 0; i < long_number_1_segments.length; i++) {
            long_number_1_segments_int[i] = Long.parseLong(long_number_1_segments[i]);
        }
        for (int i = 0; i < long_number_2_segments.length; i++) {
            long_number_2_segments_int[i] = Long.parseLong(long_number_2_segments[i]);
        }

        int max = long_number_1_segments_int.length;
        if (long_number_2_segments_int.length > max) {
            max = long_number_2_segments_int.length;
        }

        long[] result = new long[max + 1]; // +1 to handle overflow from the most significant segment

        long carry = 0;
        for (int x = max; x > 0; x--) {
            long sum = carry;
            if (long_number_1_segments_int.length >= x) {
                sum += long_number_1_segments_int[x - 1];
            }
            if (long_number_2_segments_int.length >= x) {
                sum += long_number_2_segments_int[x - 1];
            }
            result[x] = sum % 1000000000000000L; // Keep only the rightmost 15 digits
            carry = sum / 1000000000000000L; // Take the leftmost digits as carry
        }
        result[0] = carry;

        StringBuilder finalResult = new StringBuilder();
        if (result[0] != 0) {
            finalResult.append(result[0]);
        }
        for (int i = 1; i < result.length; i++) {
            finalResult.append(String.format("%015d", result[i])); // Ensure each segment has 15 digits
        }

        return finalResult.toString();
    }

    public String sum(String bigInt1, String bigInt2) {

        String[] long_number_1_segments = bigInt1.split("(?<=\\G.{15})");
        String[] long_number_2_segments = bigInt2.split("(?<=\\G.{15})");

        long[] long_number_1_segments_int = new long[long_number_1_segments.length];
        long[] long_number_2_segments_int = new long[long_number_2_segments.length];

        for (int i = 0; i < long_number_1_segments.length; i++) {
            long_number_1_segments_int[i] = Long.parseLong(long_number_1_segments[i]);
        }
        for (int i = 0; i < long_number_2_segments.length; i++) {
            long_number_2_segments_int[i] = Long.parseLong(long_number_2_segments[i]);
        }

        int max = long_number_1_segments_int.length;
        if (long_number_2_segments_int.length > max) {
            max = long_number_2_segments_int.length;
        }

        long[] result = new long[max + 1]; // +1 to handle overflow from the most significant segment

        long carry = 0;
        for (int x = max; x > 0; x--) {
            long sum = carry;
            if (long_number_1_segments_int.length >= x) {
                sum += long_number_1_segments_int[x - 1];
            }
            if (long_number_2_segments_int.length >= x) {
                sum += long_number_2_segments_int[x - 1];
            }
            result[x] = sum % 1000000000000000L; // Keep only the rightmost 15 digits
            carry = sum / 1000000000000000L; // Take the leftmost digits as carry
        }
        result[0] = carry;

        StringBuilder finalResult = new StringBuilder();
        if (result[0] != 0) {
            finalResult.append(result[0]);
        }
        for (int i = 1; i < result.length; i++) {
            finalResult.append(String.format("%015d", result[i])); // Ensure each segment has 15 digits
        }

        return finalResult.toString();
    }

    public String[] subtract() {

        return new String[] { sum("-" + n1, n2), sum(n1, "-" + n2) };
    }

    public String[] Subtract(String bigInt1, String bigInt2) {

        return new String[] { sum("-" + bigInt1, bigInt2), sum(bigInt1, "-" + bigInt2) };
    }

}