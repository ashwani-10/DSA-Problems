/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void mapping(TreeNode root,HashMap<TreeNode,TreeNode> map){
        if(root == null) return;

        if(root.left != null)
        map.put(root.left,root);

        mapping(root.left,map);

        if(root.right != null)
        map.put(root.right,root);

        mapping(root.right,map);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList();
        HashMap<TreeNode,TreeNode> map = new HashMap<>();
        mapping(root,map);
        
        Queue<TreeNode> que = new LinkedList<>();
        que.add(target);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        
        while(!que.isEmpty()){
            int size = que.size();
            if(k == 0)break;

            while(size > 0){
                TreeNode curr = que.remove();

                if(curr.left != null && !visited.contains(curr.left)) {
                    que.add(curr.left);
                    visited.add(curr.left);
                }
                if(curr.right != null && !visited.contains(curr.right)) {
                    que.add(curr.right);
                    visited.add(curr.right);
                }
                TreeNode parent = map.get(curr);
                if(parent!=null && !visited.contains(parent)){
                    que.add(parent);
                    visited.add(parent);
                }
                size--;
            }
            k--;
        }

        while(!que.isEmpty()){
            TreeNode n = que.remove();
            res.add(n.val);
        }
        return res;
    }
}