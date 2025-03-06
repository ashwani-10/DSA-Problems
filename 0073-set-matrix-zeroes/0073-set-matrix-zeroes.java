class Solution {
    public void setZeroes(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        boolean frzero = false,fczero = false;

        for(int i=0;i<n;i++){
            if(mat[i][0] == 0){
                fczero = true;
            }
        }

        
        for(int i=0;i<m;i++){
            if(mat[0][i] == 0){
                frzero = true;
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(mat[i][j] == 0){
                    mat[i][0]=0;
                    mat[0][j]=0;
                }
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(mat[i][0] ==0 || mat[0][j] == 0){
                    mat[i][j] = 0;
                }
            }
        }

        if(fczero){
            for(int i=0;i<n;i++){
                mat[i][0] = 0;
            }
        }

        if(frzero){
            Arrays.fill(mat[0],0);
        }
    }
}