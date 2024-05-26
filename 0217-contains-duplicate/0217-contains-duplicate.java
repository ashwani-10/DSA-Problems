class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> num = new HashSet<Integer>();
        
        for(int each : nums)
            num.add(each);
        
        if(num.size() != nums.length)
            return true;
        else
            return false;
    }
}