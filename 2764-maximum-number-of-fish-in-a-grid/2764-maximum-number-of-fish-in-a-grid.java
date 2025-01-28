class Pair{
    int row;
    int col;

    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}

class Solution {
    int maxFish = 0;
    int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};

    public boolean isSafe(int ni,int nj,int n,int m){
        return (ni>=0 && ni<n && nj>=0 && nj<m);
    }

    public int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] > 0){
                    q.add(new Pair(i,j));
                    int sum = grid[i][j];
                    grid[i][j] = 0;
                    while(!q.isEmpty()){
                        Pair pair = q.remove();
                        int row = pair.row;
                        int col = pair.col;
            
                        for(int[] d : dir){
                            int ni = row+d[0];
                            int nj = col+d[1];

                            if(isSafe(ni,nj,n,m) && grid[ni][nj] > 0){
                                sum += grid[ni][nj];
                                grid[ni][nj] = 0;
                                q.add(new Pair(ni,nj));
                            }
                        }
                        maxFish = Math.max(maxFish,sum);
                    }
                }
              }
            }
        return maxFish;
    }
}