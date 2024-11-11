class pair{
    int i;
    int j;
    
    pair(int i,int j){
        this.i = i;
        this.j = j;
    }
}

class Solution {
    int dir[][] = {{1,0},{0,1},{-1,0},{0,-1}};
    public boolean isSafe(int r,int c,int n,int m){
        return (r>=0 && r<n && c>=0 && c<m);
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;
        int time = 0;
        Queue<pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    
                    q.add(new pair(i,j));
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        
        while(fresh > 0 && !q.isEmpty()){
            int size = q.size();
            while(size >0){
            pair p = q.remove();
            
            int r = p.i;
            int c = p.j;
            
            for(int [] d : dir){
                int nr = r + d[0];
                int nc = c + d[1];
                
                if(isSafe(nr,nc,n,m) && grid[nr][nc] == 1){
                    grid[nr][nc] = 2;
                    q.add(new pair(nr,nc));
                    fresh--;
                }
            }
                size--;
            }
            time++;
        }
        
        return fresh != 0 ? -1:time;
    }
}