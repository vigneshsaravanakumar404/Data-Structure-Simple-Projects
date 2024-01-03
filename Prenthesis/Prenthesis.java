import java.util.Stack;

public class Prenthesis {

  public static void main(String[] args) {
    System.out.println(validParentheses("((()))"));
    System.out.println(validParentheses("(()))"));
    System.out.println(validParentheses("(()()()())"));
    System.out.println(validParentheses("((((((())"));
    System.out.println(validParentheses("()))"));
    System.out.println(validParentheses("(()()))(()"));
  }

  public static boolean validParentheses(String parenStr) {
    Stack<Character> stack = new Stack<Character>();

    for (int i = 0; i < parenStr.length(); i++) {
      char ch = parenStr.charAt(i);

      if (ch == '(') {
        stack.push(ch);
      } else if (ch == ')') {
        if (stack.empty()) {
          return false;
        }
        stack.pop();
      }
    }

    return stack.empty();
  }

}