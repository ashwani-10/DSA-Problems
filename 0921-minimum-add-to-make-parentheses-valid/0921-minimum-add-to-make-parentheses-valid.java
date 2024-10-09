class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        int res = 0;
        Stack<Character> st = new Stack();
        
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '('){
                st.push('(');
            }
            else if (!st.empty())
                st.pop();
            else res++;
        }
        
        return res+st.size();
    }
}