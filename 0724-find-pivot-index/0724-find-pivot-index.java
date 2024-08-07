class Solution {
    public int pivotIndex(int[] nums) {
        
        int n = nums.length;
        int []pref = new int[n];

        pref[0] = nums[0];

        for(int i=1;i<n;i++){
            pref[i] = pref[i-1] + nums[i];
        }

        for(int i=0;i<n;i++){
            if(i==0 && (pref[n-1] - pref[i] == 0))
               return 0;

            else if(i>0 && pref[i-1] == (pref[n-1] - pref[i]))
                return i;
            
        }
        return -1;
        
    }
}