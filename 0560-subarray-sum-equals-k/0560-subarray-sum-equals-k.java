class Solution {
    public int subarraySum(int[] arr, int tar) {
        int ans = 0;
        for(int i = 0; i < arr.length; i++) {
            int sum = 0; // Reset sum for new starting index
            for(int j = i; j < arr.length; j++) {
                sum += arr[j]; // Keep adding elements
                if(sum == tar) ans++; // Found a valid subarray
            }
        }
        return ans;
    }
}
