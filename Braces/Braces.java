import java.util.Stack;

public class Braces{

    public static void main(String[] args) {
    // Test cases
        System.out.println(isValid("(){}[]")); 
        System.out.println(isValid("([{}])")); 
        System.out.println(isValid("(}")); 
        System.out.println(isValid("[(])")); 
        System.out.println(isValid("[({})](]")); 
    }

    public static boolean isValid(String braces) {
    Stack<Character> stack = new Stack<>();

    for (char c : braces.toCharArray()) {
        switch (c) {
            case '(': 
            case '{': 
            case '[': 
                stack.push(c);
                break;
            case ')': // for close parenthesis, check and pop from stack
                if (stack.isEmpty() || stack.pop() != '(')
                    return false;
                break;
            case '}': // for close curly brace, check and pop from stack
                if (stack.isEmpty() || stack.pop() != '{')
                    return false;
                break;
            case ']': // for close square bracket, check and pop from stack
                if (stack.isEmpty() || stack.pop() != '[')
                    return false;
                break;
        }
    }

    return stack.isEmpty();
}


}