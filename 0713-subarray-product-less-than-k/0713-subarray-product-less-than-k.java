class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0; // No valid subarrays if k <= 1

        int n = nums.length;
        long product = 1; // Running product for the current subarray
        int left = 0;     // Left boundary of the window
        int res = 0;

        for (int right = 0; right < n; right++) {
            product *= nums[right]; // Include nums[right] in the product

            // Shrink the window from the left until the product is valid
            while (product >= k && left <= right) {
                product /= nums[left];
                left++;
            }

            // Add the count of valid subarrays ending at `right`
            res += (right - left + 1);
        }

        return res;
    }
}