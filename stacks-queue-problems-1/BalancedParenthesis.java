import java.util.Stack;

public class BalancedParenthesis {
    public static void main(String[] args) {
        String str = "{[()]}}";
        BalancedParenthesisSolution solution = new BalancedParenthesisSolution();
        System.out.println(solution.isValid(str));
    }
}

class BalancedParenthesisSolution {
    public boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();

        for(char ch: str.toCharArray()){
            if(ch == '{' || ch == '[' || ch == '(')
                stack.push(ch);
            else {
                if(stack.isEmpty()){
                    return false;
                }
                if( ch == ')' && stack.peek() == '('){
                    stack.pop();
                } else if( ch == '}' && stack.peek() == '{'){
                    stack.pop();
                }else if( ch == ']' && stack.peek() == '['){
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}