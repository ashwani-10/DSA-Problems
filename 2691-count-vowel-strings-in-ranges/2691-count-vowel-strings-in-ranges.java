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
        int sum = 0;
        int[] pSum = new int[words.length];
        for(int i=0;i<words.length;i++){
            String word = words[i];
            if(set.contains(word.charAt(0)) && set.contains(word.charAt(word.length()-1))){
                sum++;
            }
            pSum[i] = sum;
        }
        int[] ans = new int[n];

        for(int i=0;i<n;i++){
            int start = queries[i][0];
            int end = queries[i][1];
            ans[i] += pSum[end] - (start == 0 ? 0 : pSum[start-1]);
        }
        return ans;

    }
}