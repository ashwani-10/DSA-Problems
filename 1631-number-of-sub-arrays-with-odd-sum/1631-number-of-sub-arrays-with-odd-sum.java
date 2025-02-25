class Solution {
    int k = 2;
    public int numOfSubarrays(int[] nums) {
int n = nums.length;
        int oddCount = 0, evenCount = 1; // evenCount starts at 1 to count empty prefix sum
        int sum = 0, result = 0, mod = 1000000007;

        for (int num : nums) {
            sum += num;
            
            // If sum is odd, it forms an odd subarray
            if (sum % 2 == 1) {
                result = (result + evenCount) % mod;
                oddCount++;
            } else {
                result = (result + oddCount) % mod;
                evenCount++;
            }
        }

        return result;
    }
}