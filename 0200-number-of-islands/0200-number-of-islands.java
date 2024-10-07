class Solution {
    public void dfs(int r,int c,char[][] grid,int[][] vis){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c] == '0'){
            return;
        }

        if(vis[r][c] == 1)
        return;

        vis[r][c] = 1;

        dfs(r+1,c,grid,vis);
        dfs(r-1,c,grid,vis);
        dfs(r,c+1,grid,vis);
        dfs(r,c-1,grid,vis);


    }
    
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][] vis = new int[n][m];
        int ct =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1' && vis[i][j]==0){
                    dfs(i,j,grid,vis);
                    ct++;
                }
            }
        }
        return ct;
    }
}