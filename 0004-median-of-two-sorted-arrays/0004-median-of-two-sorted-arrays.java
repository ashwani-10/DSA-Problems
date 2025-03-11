class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int len = n+m;

        int [] nums = new int[len];
        int i=0,j=0,k=0;

        while(i<n && j<m){
            if(nums1[i] <= nums2[j]){
                nums[k] = nums1[i];
                i++;
            }else if(nums2[j] <= nums1[i]){
                nums[k] = nums2[j];
                j++;
            }
            k++;
        }

        if(i<n){
            while(i<n){
                nums[k] = nums1[i];
                i++;
                k++;
            }
        }

         if(j<m){
            while(j<m){
                nums[k] = nums2[j];
                j++;
                k++;
            }
        }

        if(nums.length%2 == 0){
            return (nums[len/2]+nums[len/2 -1])/2.0;
        }

        return nums[len/2];        
    }
}