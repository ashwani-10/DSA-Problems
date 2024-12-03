class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder res = new StringBuilder(s);
        int idx = 0;
        for(int i=0;i<spaces.length;i++){
            res.insert(spaces[i]+idx," ");
            idx++;
        }
        
        return res.toString();
    }
}