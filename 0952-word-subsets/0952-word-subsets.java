class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new ArrayList();

        int frq2[] = new int[26];

        for(int i=0;i<words2.length;i++){
            int temp[] = new int[26];

            for(char ch : words2[i].toCharArray()){
                temp[ch-'a']++;

                frq2[ch-'a'] = Math.max(temp[ch-'a'],frq2[ch-'a']);
            }
        }

        for(int i=0;i<words1.length;i++){
            int temp[] = new int[26];

            for(char ch : words1[i].toCharArray()){
                temp[ch-'a']++;
            }

            if(isUniversal(frq2,temp)){
                res.add(words1[i]);
            }
        }

        return res;
    }

    public boolean isUniversal(int[] frq2,int[] temp){
        for(int i=0;i<26;i++){
            if(temp[i] < frq2[i])
            return false;
        }
        return true;
    }
}