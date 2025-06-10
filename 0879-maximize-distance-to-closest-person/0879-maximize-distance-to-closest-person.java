class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int seatedI = -1;
        int maxD = 0;

        for(int i=0;i<n;i++){
            if(seats[i] == 1){
                if(seatedI == -1){
                    maxD = i;
                }
                else{
                    maxD = Math.max(maxD,(i - seatedI)/2);
                }
                seatedI = i;
            }
        }
        maxD = Math.max(maxD,n-1-seatedI);
        return maxD;
    }
}