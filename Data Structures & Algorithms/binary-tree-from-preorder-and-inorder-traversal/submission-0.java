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
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer , Integer> map = new HashMap<>();

        for(int  i =0 ; i<inorder.length ; i++){
            map.put(inorder[i],i);
        }
      
      return splitequal(preorder , map , 0 , 0, inorder.length-1);

        
    }

    private TreeNode splitequal(int[] preorder ,  Map<Integer , Integer> map , int rootindex , int left , int right){

        TreeNode root = new TreeNode(preorder[rootindex]);

        int mid = map.get(preorder[rootindex]);

        if(mid>left) root.left=splitequal(preorder , map , rootindex+1 , left,mid-1);

        if(mid<right) root.right=splitequal(preorder , map , rootindex +mid-left+1 , mid+1 ,right);

        return root ;
    }
}
