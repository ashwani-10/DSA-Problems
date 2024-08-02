class Solution {
    public int minSwaps(int[] nums) {
        int[] arr = new int[nums.length * 2];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i % nums.length];
            count += arr[i];
        }
        count = count / 2;

        int curSwapCount = 0;
        for (int i = 0; i < count; i++) {
            if (arr[i] == 0)
                curSwapCount += 1;
        }
        if (curSwapCount == 0)
            return curSwapCount;

        int ans = curSwapCount;
        for (int i = count; i < arr.length; i++) {
            int newNum = arr[i];
            int oldNum = arr[i - count];
            if (oldNum == 0)
                curSwapCount -= 1;
            if (newNum == 0)
                curSwapCount += 1;
            
            ans = Math.min(ans, curSwapCount);
        }

        return ans;
    }
}