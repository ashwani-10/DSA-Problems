class Solution {
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public boolean isSafe(int nx,int ny,int n,int m){
        return nx >= 0 && nx<n && ny>=0 && ny<m;
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] result = new int[n][m];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j});
                }else{
                    result[i][j] = -1;
                }
            }
        }

        while(!q.isEmpty()){
            int[] cords = q.remove();
            int i = cords[0];
            int j = cords[1];

            for(int[] d : dir){
                int nx = i+d[0];
                int ny = j+d[1];

                if(isSafe(nx,ny,n,m) && result[nx][ny] == -1){
                    result[nx][ny] = result[i][j]+1;
                    q.add(new int[]{nx,ny});
                } 
            }
        }
        return result; 
    }
}