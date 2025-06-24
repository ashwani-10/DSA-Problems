class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> indexes = new ArrayList<>();
        List<Integer> map = new ArrayList<>();
        int n = nums.length;

        for(int i=0;i<n;i++){
            if(nums[i] == key){
                map.add(i);
            }
        }

        for(int i=0;i<n;i++){
            for(int j : map){
                if(Math.abs(i-j) <= k){
                    indexes.add(i);
                    break;
                }
            }
        }

        return indexes;
    }
}