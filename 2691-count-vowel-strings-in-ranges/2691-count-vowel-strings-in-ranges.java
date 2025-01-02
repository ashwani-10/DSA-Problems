class Solution {
    Set<Character> set;
    public int[] vowelStrings(String[] words, int[][] queries) {
        set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int n = queries.length;
        int[] vowelWords = new int[words.length];
        for(int i=0;i<words.length;i++){
            String word = words[i];
            if(set.contains(word.charAt(0)) && set.contains(word.charAt(word.length()-1))){
                vowelWords[i] = 1;
            }
        }
        int[] pSum = new int[words.length];
        pSum[0] = vowelWords[0];

        for(int i=1;i<vowelWords.length;i++){
            pSum[i] = vowelWords[i] + pSum[i-1];
        }

        int[] ans = new int[n];

        for(int i=0;i<n;i++){
            int start = queries[i][0];
            int end = queries[i][1];
            if(start == end){
                ans[i] = vowelWords[start];
            }
            else if(start != 0 && start != end)
            ans[i] += pSum[end] - pSum[start-1];
            else if(start ==0)
            ans[i] += pSum[end];
        }
        return ans;

    }
}