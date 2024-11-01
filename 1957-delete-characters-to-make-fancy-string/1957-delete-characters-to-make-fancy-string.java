class Solution {
    public String makeFancyString(String s) {
        int n = s.length();
        char prev = s.charAt(0);
        int count = 1;
        StringBuilder str = new StringBuilder();
        str.append(prev);
        
        for(int i=1;i<n;i++){
            if(s.charAt(i) == prev){
                count++;
            }else{
                prev = s.charAt(i);
                count = 1;
            }
            
            if(count < 3)
                str.append(s.charAt(i));
        }
        
        return str.toString();
    }
}