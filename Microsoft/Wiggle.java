package Microsoft;

import java.util.Arrays;

public class Wiggle {


    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int res [] = new int[nums.length];
        int right = nums.length - 1;
        for(int i = 1 ; i < nums.length ; i+=2){
            res[i] = nums[right];
            right--;
        }
        for(int i = 0 ; i < nums.length ; i+=2){
            res[i] = nums[right];
            right--;
        }
        for(int i = 0 ;i < nums.length ; i++){
            nums[i] = res[i];
        }
    }
    
}
