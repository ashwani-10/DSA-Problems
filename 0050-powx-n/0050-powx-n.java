class Solution {
    public double myPow(double x, int n) {

        if(n<0){
            x=1/x;
            n=-n;
        }

        return helper(x,n);
    }

    public double helper(double x, int n) {
        // Base case: anything raised to 0 is 1
        if (n == 0) return 1;
        
        double  half = helper(x, n / 2);
        // If n is even
        if (n % 2 == 0) {
            return half*half;
        } else {  // If n is odd
            return half * half * x;
        }
    }
}