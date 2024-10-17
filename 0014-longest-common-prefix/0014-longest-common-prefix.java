class Solution {
//     public void prefix(String first,String second,int[] count){
//         int n = Math.min(first.length(),second.length());
//         int c = 0;
        
//         for(int i=0;i<n;i++){
//             if(first.charAt(i) == second.charAt(i))
//                 c++;
//             else break;
//         }
//         count[0] = Math.min(count[0],c);
//     }
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        Arrays.sort(strs);
        String ans = "";
        
        for(int i=0;i<strs[0].length();i++){
            if(strs[0].charAt(i) == strs[n-1].charAt(i))
                ans += strs[0].charAt(i);
            else break;
        }
        return ans;
    }
}