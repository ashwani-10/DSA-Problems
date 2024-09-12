class Solution {
    public int getSum(int a, int b) {
        int carry = b;
        int sum =0;
        if(a == 0) return b;
        if(b == 0) return a;
        while(carry != 0){
            sum = a^b;
            carry = (a&b) << 1;
            
            b=carry;
            a=sum;
        }
        
        return sum;
    }
}