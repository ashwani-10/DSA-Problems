class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int ans[] = new int[queries.length];
        int pref[] = new int[n];
        
        pref[0] = arr[0];
        
        for(int i=1;i<n;i++) pref[i] = pref[i-1] ^ arr[i];
        for(int i=0;i<queries.length;i++){
            int l = queries[i][0];
            int r = queries[i][1];
            
            if(l>0)
                ans[i] = pref[r] ^ pref[l-1];
            
            else ans[i] = pref[r];
        }
        
        return ans;
        
    }
}