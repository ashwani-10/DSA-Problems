class Solution {
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    public boolean isSafe(int nx,int ny,int n,int m){
        return (nx>=0 && nx<n && ny>=0 && ny<m);
    }

    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;

        int res[][] = new int[n][m];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isWater[i][j] == 1){
                    res[i][j] = 0;
                    q.add(new int[]{i,j});
                }else{
                    res[i][j] = Integer.MIN_VALUE;
                }
            }
        }

        while(!q.isEmpty()){
            int[] cords = q.remove();
            int i = cords[0];
            int j = cords[1];

            for(int[] d : dir){
                int nx = i + d[0];
                int ny = j + d[1];

                if(isSafe(nx,ny,n,m) && res[nx][ny] == Integer.MIN_VALUE){
                    res[nx][ny] = res[i][j]+1;
                    q.add(new int[]{nx,ny});
                }
            }
        }

        return res;

    }
}