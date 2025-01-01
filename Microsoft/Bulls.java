package Microsoft;

import java.util.HashMap;
import java.util.HashSet;

public class Bulls {
    public String getHint(String secret, String guess) {
        HashSet<Integer> set = new HashSet<>();
        int bulls = 0 , cows = 0 , n = secret.length();
        for(int i = 0 ;i < n ; i++){
           char ch1 = secret.charAt(i);
           char ch2 = guess.charAt(i);
           if(ch1 == ch2) {
               bulls++;
               set.add(i);
           }
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i =0 ; i < n ; i++){
            if(set.contains(i)) continue;
            else {
                char ch = secret.charAt(i);
                map.put(ch,map.getOrDefault(ch,0) + 1);
            }
        }

        for(int i = 0 ; i < n ; i++) {
            if(set.contains(i)) continue;
            char ch = guess.charAt(i);
            if(map.containsKey(ch)) {
                cows++;
                if(map.get(ch) == 1) map.remove(ch);
                else map.put(ch,map.getOrDefault(ch,0) - 1);
            }
        }
        return bulls + "A" + cows + "B";
    }
}
