class Solution {
    public int minimumOperations(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int operations = 0;
        for(int j = 0; j < m; j++){
            for(int i = 1; i < n; i++){
                if(grid[i][j] <= grid[i-1][j]){
                    operations += (grid[i-1][j]-grid[i][j])+1;
                    grid[i][j] += (grid[i-1][j]-grid[i][j])+1;
                }
            }
        }
        return operations;
    }
}