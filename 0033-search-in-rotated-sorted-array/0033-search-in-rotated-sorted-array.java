class Solution {
    public int findPivot(int [] nums,int n){
        int l = 0;
        int r = n-1;

        while(l<r){
            int mid = l+(r-l)/2;

            if(nums[mid] > nums[r]) l = mid+1;

            else r=mid;
        }
        return r;
    }

    public int binarySearch(int l,int r,int [] nums,int target){
        while(l<=r){
            int mid = l+(r-l)/2;

            if(nums[mid] == target) return mid;

            else if(nums[mid] > target) r=mid-1;

            else l = mid+1;
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int n = nums.length;
        int pivot = findPivot(nums,n);

        int idxL = binarySearch(0,pivot-1,nums,target);
        int idxR = binarySearch(pivot,n-1,nums,target);

        if(idxL != -1)
        return idxL;
        
        return idxR;
    }
}
