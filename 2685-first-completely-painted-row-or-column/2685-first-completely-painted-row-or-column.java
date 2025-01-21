class Pair{
    int row;
    int col;

    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        
        int n = mat.length;
        int m = mat[0].length;


        Map<Integer,int[]> map = new HashMap<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int val = mat[i][j];
                map.put(val,new int[]{i,j});
            }
        }

        int[] cRow = new int[n];
        int[] cCol = new int[m];

        for(int i=0;i<arr.length;i++){
            int val = arr[i];
            int[] cordi = map.get(val);

            int row = cordi[0];
            int col = cordi[1];

            cRow[row]++;
            cCol[col]++;

            if(cRow[row] == m || cCol[col] == n){
                return i;
            }
        }

        return -1;

    }
}