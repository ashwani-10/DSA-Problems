class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()) return false;
        
        boolean flag = true;
        char tempArrayS[] = s.toCharArray();
        char tempArrayT[] = t.toCharArray();

        // Sorting temp array using
        Arrays.sort(tempArrayS);
        Arrays.sort(tempArrayT);
        
        for(int i=0;i<s.length();i++){
            if(tempArrayS[i] != tempArrayT[i]){
                flag = false;
                break;
            }
        }
        
        // Returning new sorted string
        return flag;
    }
}