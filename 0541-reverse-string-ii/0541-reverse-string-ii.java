class Solution {
    public String reverseStr(String s, int k) {
        char[] str = s.toCharArray();

        for(int start=0;start<str.length;start += 2*k){
            int i = start; int j = Math.min(start+k-1,str.length-1);
            while(i<j){
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
    }
    return new String(str);
}
}