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


        Map<Integer,Pair> map = new HashMap<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int val = mat[i][j];
                map.put(val,new Pair(i,j));
            }
        }

        int[] cRow = new int[n];
        int[] cCol = new int[m];

        for(int i=0;i<arr.length;i++){
            int val = arr[i];
            Pair pair = map.get(val);

            cRow[pair.row]++;
            cCol[pair.col]++;

            if(cRow[pair.row] == m || cCol[pair.col] == n){
                return i;
            }
        }

        return -1;

    }
}