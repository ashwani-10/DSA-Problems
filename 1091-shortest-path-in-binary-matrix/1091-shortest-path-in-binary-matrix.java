class pair{
    int x;
    int y;
    int wt;
    
    pair(int x,int y,int wt){
        this.x=x;
        this.y=y;
        this.wt=wt;
    }
}

class Solution {
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};
    
    public boolean isSafe(int nx,int ny,int n,int m){
        return (nx>=0 && nx<n && ny>=0 && ny<m);
    }
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        if(n==0 || m==0 || grid[0][0] != 0) return -1;
        
        int dis[][] = new int[n][m];
        
        for(int []row : dis){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        
        Queue<pair> pq = new LinkedList<>();
        pq.add(new pair(0,0,0));
        dis[0][0] = 0;
        
        while(!pq.isEmpty()){
            pair p = pq.remove();
            
            int x = p.x;
            int y = p.y;
            int wt = p.wt;
            
            for(int [] d : dir){
                int nx = x + d[0];
                int ny = y + d[1];
                
                int dist = 1;
                
                if(isSafe(nx,ny,n,m) && grid[nx][ny] == 0 && wt+dist < dis[nx][ny]){
                    pq.add(new pair(nx,ny,wt+dist));
                    dis[nx][ny] = wt+dist;
                }
            }
        }
        if(dis[n-1][m-1] == Integer.MAX_VALUE) return -1;
        
        return dis[n-1][m-1]+1;
    }
}