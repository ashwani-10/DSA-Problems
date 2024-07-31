class Solution {
    public boolean checkString(String s) {
        int n = s.length();
        
        int i=0,j=0;
        int a =0,b=0;
        for(int k=0;k<n;k++){
            if(s.charAt(k) == 'a') a++;
            else b++;
        }
        
        if(b == 0) return true;
        else if (a==0) return true;
        
        while(j<n){
            
          while(s.charAt(i) != 'b' && i<n-1) {
            i++;
            j++;
          }
            
           if(s.charAt(j) == 'a')
               return false;
            j++;
        }
        
        return true;
    }
}