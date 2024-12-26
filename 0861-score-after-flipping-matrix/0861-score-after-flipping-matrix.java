class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++) {
            if(grid[i][0] == 0) {
                for(int j = 0; j < n; j++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }

        for(int j = 0; j < n; j++) {
            
            int zero = 0;

            for(int i = 0; i < m; i++) {
                if(grid[i][j] == 0) zero++;
            }

            if(zero > m / 2) {
                for(int i = 0; i < m; i++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }

        int ans = 0;

        for(int i = 0; i < m; i++) {
            int temp = n-1;
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1)
                        ans += Math.pow(2,temp);
                    temp--;
            }
        }

        return ans;
    }
}
