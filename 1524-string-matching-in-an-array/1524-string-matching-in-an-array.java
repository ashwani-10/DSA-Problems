class Solution {
    public List<String> stringMatching(String[] words) {
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        List<String> res = new ArrayList<>();

        for(int i=0;i<words.length-1;i++){
            String word = words[i];
            for(int j=i+1;j<words.length;j++){
                if(words[j].contains(word)){
                    if(!res.contains(word))
                    res.add(word);
                }
            }
        }
        return res;
    }
}