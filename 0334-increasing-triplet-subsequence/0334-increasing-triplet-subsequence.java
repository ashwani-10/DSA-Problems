class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        
        // To store the actual subsequence
        int firstVal = -1, secondVal = -1, thirdVal = -1;

        for (int num : nums) {
            if (num <= first) {
                first = num;
                firstVal = num;
            } else if (num <= second) {
                second = num;
                secondVal = num;
            } else {
                // Found num > second > first
                thirdVal = num;
                System.out.println(firstVal + " " + secondVal + " " + thirdVal);
                return true;
            }
        }
        return false;
    }
}