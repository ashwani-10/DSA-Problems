class Solution {
     public int[][] transpose(int[][] mat) {
        int n = mat.length; int m = mat[0].length;
             
        int [][] newMat = new int[m][n];
        
        for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
              newMat[j][i] = mat[i][j];
           }
        }
       return newMat;
    }
}