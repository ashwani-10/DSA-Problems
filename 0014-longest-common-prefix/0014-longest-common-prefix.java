class Solution {
    public void prefix(String first,String second,int[] count){
        int n = Math.min(first.length(),second.length());
        int c = 0;
        
        for(int i=0;i<n;i++){
            if(first.charAt(i) == second.charAt(i))
                c++;
            else break;
        }
        count[0] = Math.min(count[0],c);
    }
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        String first = strs[0];
        int[] count = new int[1];
        count[0] = first.length();
        String ans = "";
        
        for(int i = 1;i<n;i++){
            prefix(first,strs[i],count);
            if(count[0] == 0) return "";
        }
        
        for(int i=0;i<count[0];i++){
            ans += first.charAt(i);
        }
        System.out.print(count[0]);
        return ans;
    }
}