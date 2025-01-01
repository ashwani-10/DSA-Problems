class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int idx = 1;
        int maxSum = Integer.MIN_VALUE;
        while(idx < n){
            int zeros = 0;
            int ones = 0;
            for(int i=0;i<idx;i++){
                if(s.charAt(i) == '0'){
                    zeros++;
                }
            }

            for(int i=idx;i<n;i++){
                if(s.charAt(i) == '1'){
                    ones++;
                }
            }

            if(zeros+ones > maxSum){
                maxSum = zeros+ones;
            }
            idx++;
        }
        return maxSum;
    }
}