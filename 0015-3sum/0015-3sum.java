class Solution {
    public void twosum(int i,int j,int target,int[] nums,List<List<Integer>> result){
        while(i<j){
            if(nums[i] + nums[j] == target){
                while(i<j && nums[i] == nums[i+1])
                i++;
                while(i<j && nums[j] == nums[j-1])
                j--;

                result.add(new ArrayList<>(Arrays.asList(-target,nums[i],nums[j])));
                i++;
                j--;
            }

            else if(nums[i] + nums[j] > target)
            j--;
            else
            i++;
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for(int i=0;i<n;i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }

            int n1 = nums[i];
            int target = -n1;

            twosum(i+1,n-1,target,nums,result);
        }
        return result;
    }
}
