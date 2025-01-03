class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0;
        int count = 0;
        
        for(int i=0;i<n;i++){
            sum += nums[i];
            
            int rem = sum%k;
            
            if(rem < 0) rem += k;
            
            if(!map.containsKey(rem)){
                    map.put(rem,i);
            }

            if(map.containsKey(rem) && i - map.get(rem) > 1){
                    return true;
            }
             
        }
        return false;
    }
}