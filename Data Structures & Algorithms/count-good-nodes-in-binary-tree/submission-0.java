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
    
    public int goodNodes(TreeNode root) {
        if(root == null) return 0 ;
         
        return goodNode(root , Integer.MIN_VALUE) ;

            
    }

    private int goodNode(TreeNode root, int curmax){
        if(root == null) return 0 ;
        int curcount =0;
        if( root.val >= curmax) {
            curmax = root.val ;
            curcount = 1;
        }
        

        int left = goodNode(root.left, curmax);
        int right = goodNode(root.right,  curmax);
         
        return  left+right+curcount;
    }
}
