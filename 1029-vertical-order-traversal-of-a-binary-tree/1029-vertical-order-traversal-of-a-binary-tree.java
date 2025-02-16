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
    public void helper(TreeNode root,int c,int r,TreeMap<Integer,List<int[]>> map){
        if(root == null) return;
        
        if(map.get(c) == null){
            map.put(c,new ArrayList<>());
            map.get(c).add(new int[]{r,root.val});
        }else{
            map.get(c).add(new int[]{r,root.val});
        }
        helper(root.left,c-1,r+1,map);
        helper(root.right,c+1,r+1,map);

    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        TreeMap<Integer,List<int[]>> map = new TreeMap<>();
        helper(root,0,0,map);


        for(Integer key : map.keySet()){
            List<int[]> pair = map.get(key);

            pair.sort((a,b)-> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
            
            List<Integer> values = new ArrayList<>();
            for(int[] nodes : pair){
                values.add(nodes[1]);
            }
            res.add(values);
        }
        return res;
    }
}