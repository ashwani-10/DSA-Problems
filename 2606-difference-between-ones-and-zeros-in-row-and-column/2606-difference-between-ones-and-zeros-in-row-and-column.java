class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] row1 = new int[n];
        int[] col1 = new int[m];

        for(int i=0;i<n;i++){
            int c1 = 0;
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1)
                c1++;
            }
            row1[i] = c1;
        }

        for(int i=0;i<m;i++){
            int c1 = 0;
            for(int j=0;j<n;j++){
                if(grid[j][i] == 1)
                c1++;
            }
            col1[i] = c1;
        }

        int[][] result = new int[n][m];

        for(int i=0;i<n;i++){
            int rc1 = row1[i];
            for(int j=0;j<m;j++){
                int cc1 = col1[j];
                int value = rc1+cc1 - ((m-rc1)+(n-cc1));
                result[i][j]=value;
            }
        }

        return result;
    }
}