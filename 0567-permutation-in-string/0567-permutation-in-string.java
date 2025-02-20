class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();

        if(n > s2.length()){
            return false;
        }

        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            char ch = s1.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        //a-1,b-1

        int req_char = n;
        int i=0,j=0,start_i=0;
        int minWindow = Integer.MAX_VALUE;

        while(j<s2.length()){
            char ch = s2.charAt(j);

            if(map.containsKey(ch) && map.get(ch) > 0){
                req_char--;
            }

            map.put(ch,map.getOrDefault(ch,0)-1);

            while(req_char == 0){
                int curWindow = j-i+1;

                if(minWindow > curWindow){
                    minWindow = curWindow;
                    start_i = i;
                }

                char startCh = s2.charAt(i);
                map.put(startCh,map.getOrDefault(startCh,0)+1);

                if(map.containsKey(startCh) && map.get(startCh) > 0){
                    req_char++;
                }
                i++;
            }
            
            j++;
        }
        return minWindow == n ? true : false;
    }
}