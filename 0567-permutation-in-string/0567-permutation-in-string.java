class Solution {
    public boolean checkInclusion(String t, String s) {
        int n = t.length();

        if(n > s.length())
        return false;
        
        HashMap<Character,Integer> map = new HashMap();
        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int reqChar = t.length();
        int i=0,j=0,start_i=0;
        int minWindow = Integer.MAX_VALUE;

        while(j<s.length()){
            char ch = s.charAt(j);

            if(map.containsKey(ch) && map.get(ch)>0)
            reqChar--;

            map.put(ch,map.getOrDefault(ch,0)-1);

            while(reqChar == 0){
                int currWindow = j-i+1;

                if(minWindow > currWindow){
                    minWindow = currWindow;
                    start_i = i;
                }

                char startChar = s.charAt(i);
                map.put(startChar,map.getOrDefault(startChar,0)+1);

                if(map.containsKey(startChar) && map.get(startChar) > 0)
                reqChar++;

                i++;
            }
            j++;
        }

        return minWindow == n ? true : false;
    }
}
