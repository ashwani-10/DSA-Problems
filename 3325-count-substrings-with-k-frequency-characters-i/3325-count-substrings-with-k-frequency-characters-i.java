class Solution {
    public int numberOfSubstrings(String s, int k) {
        int n = s.length();
        int i=0;
        int count = 0;
        while(i<n){
            HashMap<Character,Integer> map = new HashMap<>();
            for(int j=i;j<n;j++){
                if(!map.containsKey(s.charAt(j))){
                    map.put(s.charAt(j),1);
                }
                else{
                    map.put(s.charAt(j),map.get(s.charAt(j)) + 1);
                }
                
                if(map.get(s.charAt(j)) >=k){
                    count += n-j;
                    break;
                }
            }
                i++;
            }
            return count;
        }
    }