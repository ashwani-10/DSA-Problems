/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countSwaps(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();            // stores [a number, its index]
        int[] sortedArr = arr.clone();                          //  make a copy of this array
        
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);                                 // stores [a number, its index] of original array
        }
        
        Arrays.sort(sortedArr);                                 // sort this copied array
        
        int swaps = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != sortedArr[i]) {                       // whenever a number is not in its correct position, swap it with correct position
                int index1 = map.get(sortedArr[i]);             // correct index - the number is to be swapped with this index
                int index2 = map.get(arr[i]);                   // wrong index - the number is currently at this index
                
				// update index in map
                map.put(arr[i], index1);                      
                map.put(sortedArr[i], index2);
				
				// swap the numbers in original array with updated index
                arr[index1] = arr[i];
                arr[index2] = sortedArr[i];
                swaps++;                                        // increase swap count
            }
        }
        
        return swaps;
    }
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int swaps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int[] nums = new int[size];
            for(int i=0;i<size;i++){
                TreeNode node = q.remove();
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
                
                nums[i] = node.val;
            }
            swaps += countSwaps(nums);
        }
            
            return swaps;
    }
}