class Solution {
    public int trap(int[] arr) {
        int sum =0;
        
        int n = arr.length;
        int [] leftMax = new int[n];
        int [] rightMax = new int[n];

        leftMax[0] = arr[0];
        rightMax[n-1] = arr[n-1];

        for(int i=1;i<n;i++){
            leftMax[i] = Math.max(leftMax[i-1],arr[i]);
        }

        for(int i=n-2;i>=0;i--){
            rightMax[i] = Math.max(rightMax[i+1],arr[i]);
        }

        for(int i=0;i<n;i++){
            int water = Math.min(leftMax[i],rightMax[i])-arr[i];
            sum += water;
        }
       
       return sum;
    }
}