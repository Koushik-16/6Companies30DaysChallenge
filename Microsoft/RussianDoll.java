package Microsoft;
import java.util.*;
class RussiaDoll {
    public int maxEnvelopes(int[][] e) {
        Arrays.sort(e,(a,b) -> {
            if(a[0] == b[0]) return b[1] - a[1];
            else return a[0] - b[0];
        });
        int dp [] = new int[e.length];
        int len = 0;
        for(int i = 0 ; i < dp.length ; i++){
            int index = binarySearch(dp,0,len,e[i][1]);
            dp[index] = e[i][1];
            if(index == len) len++;
        }
        return len;
    }
    public int binarySearch(int dp[], int start , int end , int target){
        while(start < end){
            int mid = (start + end) /2;
            if(dp[mid] == target) return mid;
            else if(dp[mid] < target) start = mid + 1;
            else end = mid;
        }
        return start;
    }
}