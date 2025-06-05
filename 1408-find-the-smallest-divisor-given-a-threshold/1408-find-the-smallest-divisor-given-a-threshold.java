class Solution {
    boolean isPossible(int[] nums, int threshold,int mid){
        int sum = 0;
        for(int num : nums){
            sum += (num+mid-1)/mid;
        }

        return sum <= threshold;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;
        for(int num : nums) high = Math.max(high,num);

        int res = 0;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(isPossible(nums,threshold,mid)){
                res = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return res;

    }
}