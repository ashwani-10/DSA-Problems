class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int res[] = new int[n-k+1];
        int i=0;
        
        while(k<=n){
            int sum = 0;
            HashMap<Integer,Integer> map = new HashMap<>();
            Set<Integer> set = new HashSet<>();
            for(int j = i;j<k;j++){
                sum += nums[j];
                set.add(nums[j]);
                map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            }
            if(set.size() < x) res[i] = sum;
            else{
                PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
				if(map.get(a) == map.get(b)) return b-a;
				return map.get(b)-map.get(a);
			});
                
            for(int ele : set) pq.add(ele);
			int ct = x;
			while(ct-- > 0) {
				int top = pq.remove();
				res[i] += (top*map.get(top));
			 }
            }
             k++;
             i++;
        }
        return res;
    }
}