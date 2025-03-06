class pair{
    int r;
    int c;
    pair(int r,int c){
        this.r=r;
        this.c=c;
    }
}

class Solution {
    public void setZeroes(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        LinkedList<pair> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    q.addLast(new pair(i,j));
                }
            }
        }

        while(q.size() > 0){
            pair p = q.removeFirst();
            int r = p.r;
            int c = p.c;

            Arrays.fill(mat[r],0);

            for(int i=0;i<n;i++){
                mat[i][c] = 0;
            }
        }
    }
}