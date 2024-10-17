class Solution {
    public void swap(int i,int j,int[]nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]=temp;
    }
    public void sortColors(int[] nums) {
        int n = nums.length;
        int i=0,j=0,k=n-1;
        
        while(j<=k){
            if(nums[j] == 1)
                j++;
            else if(nums[j] == 2){
                swap(j,k,nums);
                k--;
            }
            else{
                swap(j,i,nums);
                i++;
                j++;
            }
        }
    }
}