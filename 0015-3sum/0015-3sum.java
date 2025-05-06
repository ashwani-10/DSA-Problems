class Solution {
    List<List<Integer>> res;
    public void twoSum(int i,int j,int nums[],int target){
        while(i<j){
            int sum = nums[i]+nums[j];
            if(sum == target){
                res.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],-target)));
                while(i<j && nums[i] == nums[i+1]) i++;
                while(i<j && nums[j] == nums[j-1]) j--;
                i++;
                j--;
            }
            else if(sum > target){
                j--;
            }else{
                i++;
            }
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<n;i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            int target = -nums[i];
            twoSum(i+1,n-1,nums,target);
        }
        return res;
    }
}