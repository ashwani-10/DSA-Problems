class Solution {
    public int maxPower(String s) {
        int len = s.length();

        if(len == 0) return 0;

        int currLen = 1;
        int maxLen = 1;

        for(int i=1;i<len;i++){
            if(s.charAt(i) == s.charAt(i-1)){
                currLen++;
                maxLen = Math.max(maxLen,currLen);
            }else{
                currLen = 1;
            }
        }

        return maxLen;
    }
}