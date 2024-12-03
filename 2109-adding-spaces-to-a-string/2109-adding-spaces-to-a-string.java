class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder res = new StringBuilder();
        
        int j = 0;
        for(int i=0;i<s.length();i++){
            if(j<spaces.length && i == spaces[j]){
                res.append(" ");
                j++;
            }
            res.append(s.charAt(i));
        }
        
        return res.toString();
    }
}