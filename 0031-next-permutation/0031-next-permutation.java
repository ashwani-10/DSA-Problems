class Solution {
    public void swap(int i,int j,int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i=n-2;

        while(i>=0 && nums[i] >= nums[i+1]){
            i--;
        }

        if(i>=0){
            int j = n-1;
            while(nums[j] <= nums[i] && j>i){
                j--;
            }

            swap(i,j,nums);
        }

        while(++i<n--){
            int temp = nums[i];
            nums[i] = nums[n];
            nums[n] = temp;
        }
    }
}