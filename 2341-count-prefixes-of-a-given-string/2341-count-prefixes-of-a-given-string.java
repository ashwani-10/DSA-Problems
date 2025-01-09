class Solution {
    public int countPrefixes(String[] words, String s) {
        int ans = 0;
        for(int i=0;i<words.length;i++){
            String word = words[i];
            if(word.length() > s.length())
            continue;
            if(s.substring(0,word.length()).equals(word))
            ans++;
        }
        return ans;
    }
}