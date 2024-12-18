class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        Stack<Integer> st = new Stack();
        int[] ans = prices.clone();
            
        for(int i=0;i<n;i++){
           while(!st.empty() && prices[i] <= prices[st.peek()]){
                ans[st.peek()] -= prices[i];
                   st.pop();
        }
                st.push(i);
    }
            return ans;
  } 
}