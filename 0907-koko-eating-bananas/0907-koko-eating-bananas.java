class Solution {
    public boolean isPossible(int mid,int[] piles,int h){
        int totalH = 0;
        for(int b : piles){
            // 3,6,7,11
            totalH += Math.ceil((double) b/mid);
        }

        return totalH <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int start = 1;
        int end = Integer.MIN_VALUE;
        for(int b : piles){
            end = Math.max(end,b);
        }

        int ans = -1;
        while(start <= end){
            int mid = start + (end-start)/2;

            if(isPossible(mid,piles,h)){
                ans = mid;
                end = mid-1;
            }else{
                start = mid + 1;
            }
        }

        return ans;
    }
}