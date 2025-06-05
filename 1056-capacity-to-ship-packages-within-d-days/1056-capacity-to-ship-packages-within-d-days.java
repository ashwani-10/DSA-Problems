class Solution {
    public boolean isPossible(int[] weights,int n,int days,int mid){
        int d = 1;
        int curWeight = 0;

        for(int num : weights){
            if(num > mid) return false;
            if(curWeight + num > mid){
                d = d + 1;
                curWeight = num;
            }else{
                curWeight += num;
            }
        }

        return d <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int low = 0;
        int high = 0; 
        for(int num : weights){
            low = Math.max(low,num);
            high += num;
        }

        int res = 0;
        while(low <= high){
            int mid = low+(high-low)/2;

            if(isPossible(weights,n,days,mid)){
                res = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return res;
    }
}