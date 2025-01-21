class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long frow = 0;
        for(int i=0;i<n;i++){
            frow += grid[0][i];
        }

        long ans = Long.MAX_VALUE;
        long srow = 0;

        for(int i=0;i<n;i++){
            frow -= grid[0][i];

            ans = Math.min(ans,Math.max(srow,frow));

            srow += grid[1][i];
        }
        return ans;
    }
}