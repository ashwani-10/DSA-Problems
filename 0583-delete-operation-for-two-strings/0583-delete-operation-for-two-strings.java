class Solution {
    int[][] memo;
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        memo = new int[n+1][m+1];

        for(int[] row : memo){
            Arrays.fill(row,-1);
        }

        int lcs = LCS(word1,word2,n,m);
        return (n+m) - (2*lcs);
    }

    public int LCS(String w1, String w2,int n,int m){
        if(n == 0 || m == 0) return 0;

        if(memo[n][m] != -1) return memo[n][m];

        if(w1.charAt(n-1) == w2.charAt(m-1)){
            return memo[n][m] = 1+LCS(w1,w2,n-1,m-1);
        } 
        else
        return memo[n][m] = Math.max(LCS(w1,w2,n-1,m),LCS(w1,w2,n,m-1));
    }
}