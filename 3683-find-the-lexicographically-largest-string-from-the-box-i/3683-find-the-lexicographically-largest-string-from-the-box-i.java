class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends == 1) return word;
        
        int n = word.length();
        int maxLen = (n-numFriends+1);

        String res = "";
        for(int i=0;i<n;i++){
            String curr = word.substring(i,Math.min(i+maxLen,n));
            if(curr.compareTo(res) > 0)
            res = curr;
            
        }
        return res;
    }
}