class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] mp = new int[k];  // Array to store remainders frequency

        // Calculate the remainder frequencies
        for (int num : arr) {
            int rem = num%k;  // Handle negative remainders
            if(rem < 0)
                rem += k;
            mp[rem]++;
        }

        // Check if the frequency of numbers with 0 remainder is even
        if (mp[0] % 2 != 0) {
            return false;
        }

        // Check if each remainder has a complement remainder with matching frequency
        for (int rem = 1; rem <= k / 2; rem++) {
            int counterHalf = k - rem;
            if (mp[counterHalf] != mp[rem]) {
                return false;
            }
        }

        return true;
}
}