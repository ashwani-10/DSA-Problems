class Solution {
    List<List<Integer>> res;
    public void twoSum(int n1,int n2,int i,int j,long target,int[] nums){
        while(i<j){
            long sum = nums[i]+nums[j];
            if(sum == target){
            res.add(new ArrayList<>(Arrays.asList(nums[n1],nums[n2],nums[i],nums[j])));
            i++;
            j--;
            while (i < j && nums[i] == nums[i - 1]) i++;
            
            }else if(sum > target){
                j--;
            }else{
                i++;
            }
        }
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        res = new ArrayList<>();

        for(int i=0;i<=n-4;i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1;j<=n-3;j++){
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                long nT = nums[i]+nums[j];
                nT = target-nT;
                twoSum(i,j,j+1,n-1,nT,nums);
            }
        }
        return res;
    }
}