class Solution {
    public int minimumPushes(String word) {
        Integer[] mp = new Integer[27];
        for(int i = 0; i < 27; i++)
            mp[i] = 0;
        for(int i = 0; i < word.length(); i++){
            mp[word.charAt(i) - 'a']++;
        }
        Arrays.sort(mp,Collections.reverseOrder());
        int i = 0,cnt = 0,ans = 0;
        while(mp[i] != 0){
            if(i % 8 == 0)
                cnt++;
            ans+=(mp[i] * cnt);
            i++;
        }
        return ans;            
    }
    }
