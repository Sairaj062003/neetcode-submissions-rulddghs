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
private List<Integer> list;

    public List<Integer> postorderTraversal(TreeNode root) {
           list = new ArrayList<>();
           postorder(root);
           return list;
    }
    
    private void postorder(TreeNode node){
        
        if(node == null){
             return;
        }
        
        
        postorder(node.left);
        
        postorder(node.right);

        list.add(node.val);
    }
    
}