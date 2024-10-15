class Solution {
    public int longestOnes(int[] arr, int k) {
        int n = arr.length;
        int i=0,j=0,max_len = 0;

        while(j<n){
            if(arr[j] == 0){
                k--;
            }
            while(k < 0){
                if(arr[i] == 0) k++;
                
                i++;
            }
            max_len = Math.max(max_len,(j-i)+1);
            j++;
            
        }
        return max_len;
    }
}