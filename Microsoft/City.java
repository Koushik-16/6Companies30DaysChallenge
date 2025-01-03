package Microsoft;

import java.util.Arrays;

public class City {
    public int findTheCity(int n, int[][] edges, int threshold) {
        int dis [][] = new int[n][n];
        for(int i = 0 ; i < n ; i++) Arrays.fill(dis[i] , 100000);
        for(int e[] : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            dis[u][v] = dis[v][u] = w;
            
        }
        for(int i = 0; i < n ; i++) dis[i][i] = 0;

        for(int k = 0 ; k < n ; k++) {
            for(int i = 0; i < n ; i++) {
                for(int j = 0 ; j < n ; j++) {
                    dis[i][j] = Math.min(dis[i][j]  , dis[i][k] + dis[k][j]);
                }
            }
        }
        
      int ans = 0;
      int curr = Integer.MAX_VALUE;
        for(int i = 0; i < n ; i++) {
            int count = 0;
            for(int j = 0 ; j < n ; j++) {
               if(dis[i][j] <= threshold) count++;
            }
            if(count <= curr) {
                curr = count;
                ans = i;
            }
        }
        return ans;
    }

}
