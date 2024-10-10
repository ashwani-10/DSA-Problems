class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        
        int [] maxArr = new int[n];
        maxArr[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--){
            maxArr[i] = Math.max(nums[i],maxArr[i+1]);
        }
        
        int l=0,r=0,width=0;
        
        while(r<n){
            if(maxArr[r] >= nums[l])
                width = Math.max(width,r-l);
            
            while(l<r && nums[l] > maxArr[r])
                l++;
            
            r++;
            
        }
        return width;
    }
}