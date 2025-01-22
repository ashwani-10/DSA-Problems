class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] row1 = new int[n];
        int[] col1 = new int[m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    row1[i]++;
                    col1[j]++;
                }
            }
        }

        int[][] result = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                result[i][j]=row1[i]+col1[j] - ((m-row1[i])+(n-col1[j]));
            }
        }

        return result;
    }
}