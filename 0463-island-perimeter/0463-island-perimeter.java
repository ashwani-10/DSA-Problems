class Solution {
    public static int dfs(int r, int c, int[][] grid, int[][] vis) {
    if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
        return 1;
    }
    if (vis[r][c] == 1) {
        return 0;
    }

    vis[r][c] = 1;

    int perim = 0;
    perim += dfs(r+1, c, grid, vis); // check down neighbor
    perim += dfs(r-1, c, grid, vis); // check up neighbor
    perim += dfs(r, c+1, grid, vis); // check right neighbor
    perim += dfs(r, c-1, grid, vis); // check left neighbor

    return perim;
}

    public static int islandPerimeter(int[][] grid) {
    int r = grid.length;
    int c = grid[0].length;
    int [][] vis = new int[r][c];
    for(int i = 0; i < r; i++){
        for(int j = 0; j < c; j++){
            if(grid[i][j] == 1){
                return dfs(i, j, grid, vis);
            }
        }
    }
    return -1;
}
}