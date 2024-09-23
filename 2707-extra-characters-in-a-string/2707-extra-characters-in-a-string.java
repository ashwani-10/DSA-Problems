class Solution {
    public int minExtraChar(String s, String[] dictionary) {
         Set<String> dictSet = new HashSet<>();
        for (String word : dictionary) {
            dictSet.add(word);
        }

        int n = s.length();
        int[] DP = new int[n + 1];
        DP[0] = 0;

        for (int i = 1; i <= n; i++) {
            DP[i] = DP[i - 1] + 1;
            for (int j = 0; j < i; j++) {
                String substring = s.substring(j, i);
                if (dictSet.contains(substring)) {
                    DP[i] = Math.min(DP[i], DP[j]);
                }
            }
        }

        return DP[n];
    }
}