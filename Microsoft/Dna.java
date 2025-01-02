package Microsoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dna {
    
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        int i = 0 ; 
        while(i+10 <= s.length()){
           String curr = s.substring(i,i +10);
            i++;
            map.put(curr,map.getOrDefault(curr,0) + 1);
        }
        for(String key : map.keySet()){
            if(map.get(key) >= 2) ans.add(key);
        }
        return ans;
    }

}
