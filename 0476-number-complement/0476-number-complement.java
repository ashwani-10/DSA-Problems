class Solution {
    public int findComplement(int num) {
        int n = 0;
        for(int i=0;i<32;i++) {
            n |= num>>i;
        }
        return num^n;
    }
}