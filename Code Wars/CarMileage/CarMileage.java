public class CarMileage {

    public static boolean contains(int[] awesomePhrases, int number) {
        for (int phrase : awesomePhrases) {
            if (phrase == number)
                return true;
        }
        return false;
    }

    public static boolean palindrome(int number) {
        String str = String.valueOf(number);
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1))
                return false;
        }
        return true;
    }

    public static boolean sequential(int number, boolean incrementing) {
        String str = String.valueOf(number);
        int len = str.length();
        for (int i = 0; i < len - 1; i++) {
            if (incrementing) {
                if (str.charAt(i) == '9' && str.charAt(i + 1) == '0')
                    continue;
                if (str.charAt(i) + 1 != str.charAt(i + 1))
                    return false;
            } else {
                if (str.charAt(i) == '1' && str.charAt(i + 1) == '0')
                    continue;
                if (str.charAt(i) - 1 != str.charAt(i + 1))
                    return false;
            }
        }
        return true;
    }

    public static boolean same(int number) {
        String str = String.valueOf(number);
        return str.matches("(.)\\1+");
    }

    public static boolean zeros(int number) {
        return String.valueOf(number).matches("^[1-9]0+$");
    }

    private static boolean isInterestingNow(int number, int[] awesomePhrases) {
        return contains(awesomePhrases, number) || palindrome(number) || sequential(number, true)
                || sequential(number, false) || same(number) || zeros(number);
    }

    public static int isInteresting(int number, int[] awesomePhrases) {
        if (number < 98) {
            return 0;
        }

        if (number > 99 && isInterestingNow(number, awesomePhrases)) {
            return 2;
        }
        for (int i = number + 1; i <= number + 2; i++) {
            if (isInterestingNow(i, awesomePhrases)) {
                return 1;
            }
            ;
        }

        return 0;
    }

}
