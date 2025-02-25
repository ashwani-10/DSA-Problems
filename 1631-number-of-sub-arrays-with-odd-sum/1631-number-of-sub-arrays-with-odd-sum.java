class Solution {
    int count = 0;
    public int numOfSubarrays(int[] nums) {
        int n = nums.length;
        int odd = 0,even = 1; // even = 1 bcoz intially pSum will be 0 and 0 is even number
        int pSum = 0;

        for(int num : nums){
            pSum += num;

            if(pSum %2 != 0){
                count = (count + even) % 1000000007;
                odd++;
            }else{
                count = (count + odd) % 1000000007;
                even++;
            }
        }
        return count;
        
    }
}