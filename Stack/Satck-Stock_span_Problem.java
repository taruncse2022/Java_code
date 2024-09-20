import java.util.*;

public class StackB{
    public static int stockSpan(int stocks[] ,int span[]){
        Stack <Integer> s = new Stack<>();
        span[0]=1;
        s.push(0);
        
        int ans =0;
        for(int i=1; i<stocks.length; i++){
            int currPrice = stocks[i];
            while(!s.isEmpty() && currPrice >stocks[s.peek()]){
                ans = Math.max(ans,currPrice - stocks[s.peek()]);
                s.pop();
            }
            if(s.isEmpty()){
                span[i]=i+1;
            }else{
               int prevHigh =s.peek();
               span[i]= i- prevHigh;
            }
            
            s.push(i);
        }
        return ans;
    }
    
    public static void main(String args[]){
        
        int Stocks[]={ 100,80,60,70,60,85,100};
        int span[]= new int[Stocks.length];
        int SS = stockSpan(Stocks,span);
        
        for(int i=0; i<span.length; i++){
            System.out.println(span[i]+ "");
        }
        System.out.print(SS);
        
    }
}
