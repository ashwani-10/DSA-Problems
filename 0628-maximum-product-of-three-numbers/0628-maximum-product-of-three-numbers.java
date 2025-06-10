class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int case1 = nums[0]*nums[1]*nums[nums.length-1];
        int case2 = nums[n-1]*nums[n-2]*nums[n-3];

        return Math.max(case1,case2);

        //3 positive ele are there then max(2min*1max,3max*2max*1max)
        //2 positive ele then same max(2min*1max,3max*2max*1max)
        //1 positive ele then same max(2min*1max,3max*2max*1max)
        //0 positive ele then product of last 3
    }
}