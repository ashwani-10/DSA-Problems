class Solution {
    public boolean canMakeEqual(int[] arr,int k){
        return helper(arr,k,1) || helper(arr,k,-1);
    }
    public boolean helper(int[] arr, int k,int target) {
        int n = arr.length;
        int [] a = arr.clone();

        int count = 0;

        for(int i=0;i<n-1;i++){
            if(a[i] != target){
                a[i] *= -1;
                a[i+1] *= -1;
                count++;
            }
        }

        for(int i=0;i<n;i++){
            if(a[i] != target) return false;
        }

        return count <= k;
    }
}