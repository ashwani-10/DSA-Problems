class pair{
  int x;
  int y;
  int t;

  pair(int x,int y,int t){
    this.x=x;
    this.y=y;
    this.t=t;
  }
}
class Solution {
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

    public boolean isSafe(int nx,int ny,int n,int m){
          return (nx>=0 && nx<n && ny>=0 && ny<m);
    }
    
    public int minTimeToReach(int[][] heights) {
    int n = heights.length;
    int m = heights[0].length;

    int [][]vis = new int[n][m];
        
    for(int i=0;i<n;i++){
      Arrays.fill(vis[i],Integer.MAX_VALUE);
    }

    PriorityQueue<pair> pq = new PriorityQueue<>((p1,p2) -> (p1.t-p2.t));
    pq.add(new pair(0,0,0));
    vis[0][0] = 0;

    while(!pq.isEmpty()){
      pair p = pq.remove();
      int x =p.x;
      int y =p.y;
      int t =p.t;
        
      if(x == n-1 && y == m-1) return t;
      for(int [] ds : dir){
        int nx = x + ds[0];
        int ny = y + ds[1];

        if(isSafe(nx,ny,n,m) && vis[nx][ny] == Integer.MAX_VALUE){
            int maxtime = Math.max(t,heights[nx][ny])+1;
            pq.add(new pair(nx,ny,maxtime));
            vis[nx][ny] = maxtime;
        }
      }
    }
    return -1;
    }
}