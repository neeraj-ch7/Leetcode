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
    void fun(TreeNode r){
        if(r ==null){
            return;
        }
        TreeNode temp = r.right;
        r.right = r.left;
        r.left = temp;

        fun(r.right);
        fun(r.left);

        return ;
    }
    public TreeNode invertTree(TreeNode root) {
        fun(root);
        return root;
    }
}