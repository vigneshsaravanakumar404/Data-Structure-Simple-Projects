import java.util.Stack;

public class Expanded{

    public static void main(String[] args){
        
        System.out.println(expandedForm(12));
        System.out.println(expandedForm(42));
        System.out.println(expandedForm(70304));
        System.out.println(expandedForm(9000000));
        System.out.println(expandedForm(9000001));
        System.out.println(expandedForm(9000010));
        System.out.println(expandedForm(9000100));
        System.out.println(expandedForm(9001000));
        System.out.println(expandedForm(9010000));
        System.out.println(expandedForm(9100000));
        System.out.println(expandedForm(1000000));
        
    }


    public static String expandedForm(int num)
    {   
        Stack<String> stack = new Stack<String>();
        int place = 10;
      
        while (num % place != num){
            if (num % place != 0){
                stack.push(Integer.toString(num % place));
                num = num - (num % place);
            }
            place = place * 10;
        }
        stack.push(Integer.toString(num));
        
        String result = "";
        while (!stack.empty()){
            String temp = stack.pop();
            if (temp != "0"){
                result = result + temp;
                if (!stack.empty()){
                    result = result + " + ";
                }
            }
        }
        return result;
    }
}