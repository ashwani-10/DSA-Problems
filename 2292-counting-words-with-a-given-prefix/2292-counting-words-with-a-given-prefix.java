class Solution {
    public int prefixCount(String[] words, String pref) {
        int plen = pref.length();
        int ans = 0;
        for(int i=0;i<words.length;i++){
            String word = words[i];
            if(plen > word.length())
            continue;
            if(word.substring(0,plen).equals(pref))
            ans++;
        }
        return ans;
    }
}