class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int n = nums.length;
        Arrays.sort(nums);
        TreeSet<String> set = new TreeSet<String>();
        for(int i=0;i<n-2;i++){
            int left = i+1;
            int right = n-1;
            
            while(left < right){
                ArrayList<Integer> curr = new ArrayList<>();
                int sum = nums[i] + nums[left] + nums[right];
                
                if(sum == 0){
                    String str = nums[i]+":" + nums[left]+":" + nums[right];
                    if(!set.contains(str)){
                        set.add(str);
                        curr.add(nums[i]);
                        curr.add(nums[left]);
                        curr.add(nums[right]);
                        res.add(curr);
                    }
                    left++;
                    right--;
                }
                else if(sum > 0){
                    right--;
                }
                 else if(sum < 0){
                    left++;
                }
            }
        }
        return res;
    }
}