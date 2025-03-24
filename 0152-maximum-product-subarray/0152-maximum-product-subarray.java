class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int pd = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int p = 1;
            for(int j=i;j<n;j++){
                p *= nums[j];
                if(p > pd){
                    pd = p;
                }
            }
        }
        return pd;
    }
}