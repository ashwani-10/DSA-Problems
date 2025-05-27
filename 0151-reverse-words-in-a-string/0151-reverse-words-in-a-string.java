class Solution {
    public String reverseWords(String s) {
        String words[] = s.trim().split("\\s+");

        int i=0,j=words.length-1;

        while(i<j){
            String word = words[i];
            words[i] = words[j];
            words[j] = word;
            i++;
            j--;
        }
        String res = "";

        for(int I=0;I<words.length;I++){
            if(I == words.length-1){
                res += words[I];
            }else
            res += words[I]+" ";
        }
        return res;
    }
}