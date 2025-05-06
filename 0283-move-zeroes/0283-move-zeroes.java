class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;

        int i=0;
        int j=0;

        while(j<n){
            if(nums[j] > 0 || nums[j] < 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
            j++;
        }
    }
}