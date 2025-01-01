class Solution {
    public String removeOccurrences(String s, String part) {
        Stack<Character> st = new Stack<>();

        for(char c : s.toCharArray()){
            st.push(c);
            if(st.size() >= part.length() && st.peek() == part.charAt(part.length()-1)){
                StringBuilder temp = new StringBuilder();

                for(int i=0;i<part.length();i++){
                    temp.append(st.pop());
                }
                temp.reverse();

                if(!temp.toString().equals(part)){
                    for(char ch : temp.toString().toCharArray()){
                        st.push(ch);
                    }
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}