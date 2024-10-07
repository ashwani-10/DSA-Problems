class Solution {
   public static void dfs(int r,int c,int[][] grid,int[][] vis,int []perimeter){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c] == 0){
            perimeter[0]++;
            return;
        }

        if(vis[r][c] == 1)
        return;

        vis[r][c] = 1;

        dfs(r+1,c,grid,vis,perimeter);
        dfs(r-1,c,grid,vis,perimeter);
        dfs(r,c+1,grid,vis,perimeter);
        dfs(r,c-1,grid,vis,perimeter);


    }

    public static int islandPerimeter(int[][] grid) {
        // your code here
        int r = grid.length;
        int c = grid[0].length;
        int [][] vis = new int[r][c];
        int []count =new int[1];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j] == 1){
                    dfs(i,j,grid,vis,count);
                    return count[0];
                }
            }
        }
        return -1;
    }
}