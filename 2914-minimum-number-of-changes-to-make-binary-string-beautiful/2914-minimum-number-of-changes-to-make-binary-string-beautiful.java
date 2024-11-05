class Solution {
    public int minChanges(String s) {
        int n = s.length();
        
        char ch = s.charAt(0); // starting character
        int count = 0;
        int changes = 0;
        
        for(int i=0;i<n;i++){
            if(s.charAt(i) == ch){
                count++;
                continue;
            }
            
            if(count%2 == 0){
                count = 1; // as pre partition is of even length reset count for new chara
            }
            else{
                changes += 1;
                count = 0;
            }
            
            ch = s.charAt(i);
        }
        return changes;
    }
}