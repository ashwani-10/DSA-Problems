//1 2 3 4 6 6 6 6 6 4 3 2 1

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        int left = 0;
        int right = n-1;

        while(left < right){
            int mid = left+(right-left)/2;

            if(nums[mid] < nums[mid+1]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}