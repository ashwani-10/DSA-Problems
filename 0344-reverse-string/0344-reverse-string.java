class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        int j = n-1;

        for(int i=0;i<j;i++){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            j--;
        }
    }
}