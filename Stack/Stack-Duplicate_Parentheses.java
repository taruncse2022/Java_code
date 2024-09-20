import java.util.*;

public class Classroom{
    
    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
        
            //closing
            if (ch == ')') {
                int count = 0;
                while (!s.isEmpty() && s.peek() != '(') {
                    s.pop();
                    count++;
                }    
                if (!s.isEmpty()) {
                    s.pop(); 
                }
                if (count < 1) {
                    return true; // duplicate found
                }
            } else {
                s.push(ch);
            }
        }
        return false;
    }     
    public static void main(String args[]){
        String str = "((a+b))";//true
        String str1 = "(a-b)"; //false
        System.out.println(isDuplicate(str));
        System.out.println(isDuplicate(str1));
    }
}
