class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }

        int result = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            int maxIndex = Integer.MIN_VALUE;
            for(int j=0;j<m;j++){
                int idx = map.get(mat[i][j]);

                maxIndex = Math.max(maxIndex,idx);
            }
            result = Math.min(maxIndex,result);
        }

        for(int i=0;i<m;i++){
            int maxIndex = Integer.MIN_VALUE;
            for(int j=0;j<n;j++){
                int idx = map.get(mat[j][i]);

                maxIndex = Math.max(maxIndex,idx);
            }
            result = Math.min(maxIndex,result);
        }

        return result;

    }
}