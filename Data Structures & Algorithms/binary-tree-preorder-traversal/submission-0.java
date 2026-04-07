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

    public List<Integer> preorderTraversal(TreeNode root) {
           list = new ArrayList<>();
           preorder(root);
           return list;
    }
    
    private void preorder(TreeNode node){
        
        if(node == null){
             return;
        }
        list.add(node.val);
        
        preorder(node.left);
        
        preorder(node.right);
    }
}