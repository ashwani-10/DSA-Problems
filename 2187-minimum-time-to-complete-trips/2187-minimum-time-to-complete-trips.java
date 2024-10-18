class Solution {
    public boolean check(int[] time,long mid_time,int totalTrips){
        long trips = 0;
        
        for(int t : time){
            trips += (mid_time/t);
        }
        
        return trips >= totalTrips ? true : false;
    }
    public long minimumTime(int[] time, int totalTrips) {
        int n = time.length;
        long l = 1;
        long r = Long.MIN_VALUE;
        for(int t : time){
            r = Math.max(r,(long)t);
        }
        r = (long) r*totalTrips;
        
        while(l<=r){
            long mid = l+(r-l)/2;
            
            if(check(time,mid,totalTrips)){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
}