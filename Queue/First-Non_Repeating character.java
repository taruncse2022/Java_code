import java.util.*;

public class Classroom{
    
    public static char printNotRepeating(String str){
        int freq[] = new int[26];
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            freq[ch-'a']++;    
        }
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(freq[ch-'a']==1){
                return ch;
            }
        }
        return 'a';
    }
    
    public static void main(String args[]){
        String str = "aabccxb";    
        char print = printNotRepeating(str); 
        System.out.print(print);
    }
}
