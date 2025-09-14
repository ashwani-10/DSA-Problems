class Solution {
    public int[] maxKDistinct(int[] arr, int k) {
        int n = arr.length;

        Arrays.sort(arr);
        int[] res = new int[Math.min(k, n)];
        int curNum = arr[n-1];
        int idx = 0;
        res[idx++] = curNum;

        for(int i = n-2;i>=0 && idx < k;i--){
            if(arr[i] != curNum){
            curNum = arr[i];
            res[idx] = curNum;
            idx++;
            }
        }
        /*
        77,84,93,93,100
        idx ->1,
        res -> 100,
        */

        if(idx < k){
            return Arrays.copyOf(res, idx);
        }

        return res;
    }
}