import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {

        System.out.println(validParentheses1("()()("));
    }

    public static boolean validParentheses1(String parenStr) {

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < parenStr.length(); i++) {
            stack.add(parenStr.charAt(i));
        }

        for (int i = 0; i < parenStr.length(); i++) {
            if (stack.pop() != '(') {
                return false;
            }
        }
    }
}
