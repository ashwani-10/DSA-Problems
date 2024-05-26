class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int ans[] = new int[2];
        int n = numbers.length;
        int i = 0;
        int j = n-1;
        
        while(i<j){
            if(numbers[i]+numbers[j] == target){
                ans[0] = i;
                ans[1] = j;
                break;
            }
            
            else if(numbers[i]+numbers[j] > target){
                j--;
            }
            else if(numbers[i]+numbers[j] < target){
                i++;
            }
        }
        ans[0] +=1;
        ans[1] +=1;
        return ans;
    }
}