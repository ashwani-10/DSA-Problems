class Solution {
    public void swap(int i,int j, int[]arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    public void helper(int[]arr, int n, int idx, List<List<Integer>> result){
        if(idx == n){
            List<Integer> temp = new ArrayList();
            for(int num : arr){
                temp.add(num);
            }
            result.add(temp);
            return;
        }

        for(int i=idx;i<n;i++){
            swap(i,idx,arr);
            helper(arr,n,idx+1,result);
            swap(i,idx,arr);
        }
    }
    public List<List<Integer>> permute(int[] arr) {
        int n = arr.length;
        List<List<Integer>> result = new ArrayList();
        
        helper(arr,n,0,result);
        
        return result;
    }
}