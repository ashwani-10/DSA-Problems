class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int [] res = new int[n];
        int low = 0,high = n-1,pos = n-1;

        while(low <= high){
            int ls = nums[low] * nums[low];
            int rs = nums[high] * nums[high];

            if(ls > rs){
                res[pos--] = ls;
                low++;
            }else{
                res[pos--] = rs;
                high--;
            }
        }
        return res;
    }
}