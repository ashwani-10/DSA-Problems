class Solution {
    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";

        char[] carr = s.toCharArray();
        int i=0;
        int j=s.length()-1;

        while(i<j){
            if(!vowels.contains(String.valueOf(carr[i]))){
                i++;
                continue;
            }

            if(!vowels.contains(String.valueOf(carr[j]))){
                j--;
                continue;
            }

            char ch = carr[i];
            carr[i] = carr[j];
            carr[j] = ch;

            i++;
            j--;
        }

        return new String(carr);
    }
}