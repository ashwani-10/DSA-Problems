class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int ans[] = new int[n];

        HashMap<Integer,Integer> map = new HashMap<>();

      for(int i=0;i<n;i++){
            map.put(A[i],1);
            int count = 0;
        
        for(int j=0;j<=i;j++){
          if(map.containsKey(B[j])){
                count++;
                ans[i] = count;
          }
      }
    }
    return ans;
  }
}