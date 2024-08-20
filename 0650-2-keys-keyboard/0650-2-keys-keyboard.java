class Solution {
    public int minSteps(int n) {
          int curr = 1;   //initial 'A's
        int prev = 0;   //previous String
        int steps = 0;      //steps
        
        while(curr < n){    
            if(n%curr==0){      //if we can reach n by just doubling
                prev = curr;    //copy
                curr += prev;   //paste
                
                steps+=2;       //copy + paste = 2 steps
            }
            else{
                curr += prev;   //just paste
                
                steps+=1;       //paste = 1 step
            }
        }
        
        return steps;
    }
}