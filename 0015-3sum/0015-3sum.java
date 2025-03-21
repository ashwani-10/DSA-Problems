class Solution {
    List<List<Integer>> res;

    public void twoSum(int i,int j,int target,int[] nums){
        while(i<j){
            int sum = nums[i]+nums[j];
            if(sum == target){
                while(i<j && nums[i] == nums[i+1]) i++;
                while(i<j && nums[j] == nums[j-1]) j--;
                res.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],-target)));
                i++;
                j--;
            }else if(sum > target){
                j--;
            }else{
                i++;
            }
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for(int i=0;i<n;i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            int target = -nums[i];
            twoSum(i+1,n-1,target,nums);
        }
        return res;
    }
}