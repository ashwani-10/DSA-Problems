class Solution {
    public long numberOfSubsequences(int[] nums) {
        int n = nums.length;
        long res = 0;

        Map<Double,Integer> map = new HashMap<>();

        for(int r=3;r<n-2;++r){
            int q = r-2;
            for(int p=0;p<q-1;++p){
                double key = 1.0* nums[p]/nums[q];
                map.put(key,map.getOrDefault(key,0)+1);
            }

            for(int s = r+2; s<n; ++s){
                double key = 1.0* nums[s]/nums[r];
                res += map.getOrDefault(key,0);
            }
        }

        return res;
    }
}