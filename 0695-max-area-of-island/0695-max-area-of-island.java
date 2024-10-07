class Solution {
    public void dfs(int r,int c,int[][] grid,int[][] vis,int []area){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c] == 0 || vis[r][c]==1){
            return;
        }
        if(grid[r][c]==1 && vis[r][c]==0)
        area[0]++;

        vis[r][c] = 1;

        dfs(r+1,c,grid,vis,area);
        dfs(r-1,c,grid,vis,area);
        dfs(r,c+1,grid,vis,area);
        dfs(r,c-1,grid,vis,area);


    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][] vis = new int[n][m];
        int []area =new int[1];
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1 && vis[i][j]==0){
                    dfs(i,j,grid,vis,area);
                    ans = Math.max(ans,area[0]);
                    area[0]=0;
                }
            }
        }
        return ans;
    }
}
