class pair{
    int first;
    int second;
    
    pair(int x,int y){
        first = x;
        second = y;
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
        
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(0,0));
        grid[0][0] = 1;
        
        int level = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size > 0){
            pair p = q.remove();
            
            int x = p.first;
            int y = p.second;
            
            if(x==n-1 && y== m-1) return level+1;
            
            for(int [] d : dir){
                int nx = x + d[0];
                int ny = y + d[1];
                
                if(isSafe(nx,ny,n,m) && grid[nx][ny] == 0){
                    q.add(new pair(nx,ny));
                    grid[nx][ny] = 1;
                }
            }
                size--;
        }
            level++;
        }
        return -1;
    }
}