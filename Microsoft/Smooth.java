package Microsoft;
class Smooth {
    public int[][] imageSmoother(int[][] img) {
         int n = img.length;
         int m = img[0].length;
         int arr [][] = new int[n][m];
         for(int i = 0; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                arr[i][j] = smooth(i , j, img);
            }
         }
         return arr;
    }


    public int smooth(int i , int j , int img [][]) {
         int n = img.length;
         int m = img[0].length;
         int x [] = {0,0 ,-1 ,-1,-1,0,1,1,1};
         int y [] = {0,-1,-1 , 0,1,1,1,0,-1};
         int count = 0;
         int val = 0;
         for(int k = 0 ; k < x.length ; k++) {
            int row = i + x[k];
            int col = j + y[k];
            if(row >= 0 && col >= 0 && row < n && col < m) {
                count++;
                val += img[row][col];
            }
         }
         return val / count;
    }
}