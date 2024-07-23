class Solution {
    public int[] productExceptSelf(int[] a) {
        
      int n = a.length;  
      int pref[] = new int[n];
      int sufi[] = new int[n];

      pref[0] = a[0];
      sufi[n-1] = a[n-1];
        
      int ans[] = new int[n];
      for(int i=1;i<n;i++){
          pref[i] = pref[i-1] * a[i];
      }
      
      for(int i=n-2;i>0;i--){
          sufi[i] = sufi[i+1]*a[i];
      }

      ans[0] = sufi[1];
      ans[n-1] = pref[n-2];
      for(int i=1;i<n-1;i++){
          ans[i] = pref[i-1]*sufi[i+1];
      }

      return ans;
        
    }
}