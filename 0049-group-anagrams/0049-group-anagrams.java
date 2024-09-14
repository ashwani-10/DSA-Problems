class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        
        for(String word : strs){
            char[] c = word.toCharArray();
            Arrays.sort(c);
            
            String str = new String(c);
            
            if(!map.containsKey(str)){
                map.put(str,new ArrayList());
            }
            map.get(str).add(word);
        }
        
        return new ArrayList<>(map.values());
    }
}