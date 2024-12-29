class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends == 1) return word;
        
        int n = word.length();
        int maxLen = (n-numFriends+1);

        String res = "";
        char maxchar = word.charAt(0);
        for(int i=0;i<n;i++){
            if(word.charAt(i) >= maxchar){
            String curr = word.substring(i,Math.min(i+maxLen,n));
            if(curr.compareTo(res) > 0)
            res = curr;
            maxchar = word.charAt(i);
            }
        }
        return res;
    }
}