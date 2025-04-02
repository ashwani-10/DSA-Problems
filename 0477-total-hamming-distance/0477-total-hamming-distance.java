class Solution {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int res = 0;
        
        for (int i = 0; i < 32; i++) {  // 32-bit integers
            int countOnes = 0;
            
            for (int num : nums) {
                countOnes += (num >> i) & 1;  // Extract ith bit
            }
            
            int countZeros = n - countOnes;  // Remaining are 0s
            res += countOnes * countZeros;   // Count total pairs can be formed with different bits
        }
        
        return res;
    }

    // Brute force
    public int hammingDistance(int a, int b) {
    int count = 0;
    for(int i=0;i<32;i++){
        if (((a >> i) & 1) != ((b >> i) & 1)) { // If bits are different
            count++;
        }
    }

    return count;
    }
}