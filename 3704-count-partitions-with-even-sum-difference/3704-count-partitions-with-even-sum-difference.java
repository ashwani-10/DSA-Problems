class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;

        int[] p = new int[n];
        p[0] = nums[0];

        for(int i=1;i<n;i++){
            p[i] = p[i-1] + nums[i];
        }
        //10 20 23 30 36
        int count = 0;
        for(int i=0;i<n-1;i++){
            //-16,4,10,24
            int dif = Math.abs(p[i] - (p[n-1] - p[i])); // 23 - (36 - 23)
            if(dif%2 == 0)
            count++;
        }
        return count;
    }
}