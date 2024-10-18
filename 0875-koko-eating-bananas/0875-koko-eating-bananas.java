class Solution {
    public static boolean check(int[] piles,int mid,int hour){
        int eatH = 0;
        
        for(int num : piles){
            eatH += num/mid;
            
            if(num%mid != 0)
            eatH++;
        }

        return eatH <= hour ? true : false;
    }
    
    public int minEatingSpeed(int[] piles, int H) {
        int n = piles.length;
        int l = 1;
        int r = Integer.MIN_VALUE;
        for(int num : piles){
            r = Math.max(r,num);
        }

        while(l<r){
            int mid = l+(r-l)/2;

            if(check(piles,mid,H)){
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
}