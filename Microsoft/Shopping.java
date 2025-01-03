package Microsoft;
import java.util.*;

public class Shopping {

        public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
            int n = price.size();
            return dfs(0,price , special , needs);
        }
    
        public int dfs(int i ,List<Integer> price, List<List<Integer>> special, List<Integer> needs ) {
            if(i == special.size()) {
                int sum = 0;
               for(int j = 0 ; j < needs.size() ;j++) {
                  sum += (needs.get(j) * price.get(j));
               }
               return sum;
            }
            int n = special.get(i).size();
                int ans = Integer.MAX_VALUE;
                if(less(special.get(i),needs)) {
                    for(int j = 0 ; j < needs.size() ; j++) {
                        needs.set(j,needs.get(j) - special.get(i).get(j));
                    }
                   ans = Math.min(ans, special.get(i).get(n-1) + dfs(i,price,special,needs));
                   for(int j = 0 ; j < needs.size() ; j++) {
                        needs.set(j,needs.get(j) + special.get(i).get(j));
                    }
                }
                ans = Math.min(ans,dfs(i+ 1,price,special,needs));
                return ans;
        }
    
        
        public boolean less(List<Integer> list , List<Integer> needs ) {
            boolean ans = true;
            for(int i = 0 ; i < needs.size() ; i++) {
                if(list.get(i) > needs.get(i))  return false;
            }
            return true;
        }
    
}
