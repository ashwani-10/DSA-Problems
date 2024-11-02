class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n+1];
        int count = 0;
        
        for(int i=2;i*i<=n;i++){
            if(!isPrime[i]){
                for(int j=i*i;j<=n;j=j+i){
                    isPrime[j] = true;
                }
            }
        }

        for(int i=2;i<n;i++){
            if(!isPrime[i])
            count++;
        }
        return count;
    }
}