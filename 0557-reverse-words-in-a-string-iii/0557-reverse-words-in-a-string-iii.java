class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        int start = 0;
        StringBuilder res = new StringBuilder();

        while(start < n){
            int end = start;

            while(end < n && s.charAt(end) != ' ') end++;

            for(int i=end-1;i>=start;i--){
                res.append(s.charAt(i));
            }

            if(end < n) res.append(' ');

            start = end+1;
        }
        return res.toString();
    }
}