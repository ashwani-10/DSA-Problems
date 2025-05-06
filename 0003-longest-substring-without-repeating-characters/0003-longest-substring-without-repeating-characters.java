class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i=0;
        int j=0;
        int maxLen = 0;

        Set<Character> set = new HashSet();

        while(j<n){
            char ch = s.charAt(j);
            while(set.contains(ch)){
                set.remove(s.charAt(i));
                i++;
            }
            set.add(ch);
            maxLen = Math.max(maxLen,j-i+1);
            j++;
        }
        return maxLen;
    }
}