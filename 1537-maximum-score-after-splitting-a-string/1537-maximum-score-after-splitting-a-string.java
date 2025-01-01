class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int maxSum = Integer.MIN_VALUE;

        int ones = 0;
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '1') ones++;
        }
        int zeros = 0;
        for(int i=0;i<n-1;i++){
            if(s.charAt(i) == '1'){
                ones--;
            }else{
                zeros++;
            }

            maxSum = Math.max(maxSum,zeros+ones);
        }
        
        return maxSum;
    }
}