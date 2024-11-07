class Solution {
    public boolean solve(int[] bloomDay,int mid,int m,int k){
        int count = 0;
        int boo = 0;

        for(int num : bloomDay){
            if(num <= mid){
                count++;
                if(count == k){
                    boo++;
                    count = 0;
                }
            }
            else{
                count = 0;
            }
        }

        if(boo >= m) return true;

        return false;
    }
    
    public int minDays(int[] bloomDay, int m, int k) {
       int l = Integer.MAX_VALUE;
       int r = Integer.MIN_VALUE;

       for(int num : bloomDay){
        l = Math.min(l,num);
        r = Math.max(r,num);
       }

       while(l<r){
        int mid = l+(r-l)/2;

        if(solve(bloomDay,mid,m,k)){
            r=mid;
        }
        else
        l=mid+1;
       }
       if(!solve(bloomDay,l,m,k)) return -1;

       return r;
    }
}