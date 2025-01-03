package Microsoft;

import java.util.ArrayList;

public class Nice {
    public int numberOfSubarrays(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n ; i++ ){
            if(nums[i] % 2 == 1) list.add(i);
        }
        if(list.size() == 0) return 0;
        int i = 0;
        int j = 0;
        while(j < list.size() && k - 1 > 0){
           j++; 
            k--;
        }
       int ans = 0;
        while(j < list.size()){
            int b = i == 0 ? list.get(i) + 1 :list.get(i) - list.get(i - 1);
    int a = j == list.size() - 1 ? n - list.get(j) : list.get(j + 1) - list.get(j);
            ans += (a * b);
            i++;
            j++;
        }
        return ans;
        
        
        
    }

}
