import java.util.*;

public class ValidParentheses {
    // Each variable should be compared with all other variables.
    // The match may or may not appear in the future. So i need to put current
    // variable in suspend mode. And also it should be sequence order
    // So we can use stack.

    private static final Map<Character, Character> paraMap = Map.of('(', ')', '{', '}', '[', ']');

    public boolean isValid(String s) { 
        
        Stack<Character> stack = new Stack();
        for(char currentChar : s.toCharArray()) {
            if(paraMap.containsKey(currentChar)) { //If it is opening
                stack.push(currentChar);
            } else { //If it is closing
                if(stack.isEmpty() || paraMap.get(stack.peek()) != currentChar) { 
                    return false;
                } else {
                    stack.pop();
                } 
            }
        }
        return stack.isEmpty();
    }

    public boolean isValidApproach2(String s) {
      

        Stack<Character> stack = new Stack();

        for(int i=0;i<s.length();i++) {
            char currentChar = s.charAt(i);
            switch(currentChar) {
                 case '(':
            
                 case '[': 
                case '{':
                     insertIntoStack(stack, currentChar);
                    break;
                c ase ')':
                case ']':
                case '}':
                    if(checkIfLastElementIsClosing (stack, currentChar)) {
                        stack.pop();
                    } else {
                        return false;
                    }
                break;
            }  
        }
        return stack.isEmpty();
    }

    private void insertIntoStack(Stack<Character> stack, char c) {
        stack.push(c);
    }

    private boolean checkIfLastElementIsClosing(Stack<Character> stack, char c) {
        if (stack.isEmpty())
            return false;
        if (stack.peek().equals('(')) {
            return c == ')';
        } else if (stack.peek().equals('[')) {
            return c == ']';
        } else if (stack.peek().equals('{')) {
            return c == '}';
        }
        return false;
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        boolean result = validParentheses.isValid("]");
        System.out.println("The result is: " + result);
    }
}