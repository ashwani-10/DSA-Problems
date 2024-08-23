class Solution {
    public int findGCD(int a, int b) {
        return a!=0? findGCD(b%a, a): b;
    }
    
    public String fractionAddition(String expression) {
        String fracs[] = expression.split("(?=[+-])");
        int resNumerator = 0, resDenominator = 1;
        for(String frac: fracs) {
            String fracSplitted[] = frac.split("/");
            int num = Integer.parseInt(fracSplitted[0]);
            int denom = Integer.parseInt(fracSplitted[1]);
            resNumerator = resNumerator*denom + num*resDenominator;
            resDenominator = resDenominator * denom;
            
            int gcd = findGCD(resNumerator, resDenominator);
            resNumerator /= gcd;
            resDenominator /= gcd;
        }
        String sign = resNumerator<0 || resDenominator<0? "-" : "";
        
        return sign + Math.abs(resNumerator) + "/" + Math.abs(resDenominator);
    }
}