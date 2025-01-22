class Pair{
    int key;
    int frq;

    Pair(int key,int frq){
        this.key = key;
        this.frq = frq;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1,p2) -> (p1.frq-p2.frq));

        for(Integer ky : map.keySet()){
            int key = ky;
            int frq = map.get(ky);

            pq.add(new Pair(key,frq));

            if(pq.size() > k){
                pq.remove();
            }
        }

        int[] ans = new int[k];
        int i=0;
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            ans[i] = p.key;
            i++;
        }
        return ans;
    }
}