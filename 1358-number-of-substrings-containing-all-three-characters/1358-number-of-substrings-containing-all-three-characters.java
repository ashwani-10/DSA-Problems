class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
		int i=0,j=0,res=0;
		HashMap<Character,Integer> map = new HashMap();
		while(j<n){
			char ch = s.charAt(j);

			if(map.size()<3){
				map.put(ch,map.getOrDefault(ch,0)+1);
			}

			while(map.size() == 3){
				res += n-j;
				if(map.get(s.charAt(i)) == 1)
				map.remove(s.charAt(i));

				else
				map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)-1);

				i++;
			}
			j++;
		}

		return res;
    }
}