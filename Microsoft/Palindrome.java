package Microsoft;
import java.util.*;;
public class Palindrome {

    public int maxProduct(String s) {
        HashMap<Integer,String> set = new HashMap<>();
        int mask = 0;
        helper(0,s.toCharArray(),new StringBuilder(),0,set);
        int max = 1;
        for(int key : set.keySet()){
            for(int k : set.keySet()){
                if((key&k) == 0) max = Math.max(max,set.get(key).length() * set.get(k).length());
            }
        }
        return max;
    }
    
public void helper(int ind,char ch [],StringBuilder sb ,int mask,HashMap<Integer,String> set ){
        if(ind >= ch.length){
            String s  = sb.toString();
            if(isPalindrome(s)){
                set.put(mask,s);
            }
            return ;
        }
    sb.append(ch[ind]);
        helper(ind + 1,ch,sb,mask|(1<<ind),set);
    sb.deleteCharAt(sb.length() -1);
        helper(ind + 1,ch,sb,mask,set);
    }
    
    public boolean isPalindrome(String s){
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    
}
