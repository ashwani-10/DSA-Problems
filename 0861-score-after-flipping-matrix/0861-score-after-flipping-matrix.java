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
            int temp = 0;
            for(int j = 0; j < n; j++) {
                temp = temp * 2 +  grid[i][j];
            }

            ans += temp;
        }

        return ans;
    }
}
