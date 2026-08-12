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
     boolean fun(TreeNode v1 , TreeNode v2){
        if(v1 == null && v2 == null){
            return true;
        }
        if(v1 == null || v2 == null){
            return false;
        }

        if(v1.val != v2.val){
            return false;
        }
        boolean r1 = fun(v1.left,v2.left);
        boolean r2 = fun(v1.right,v2.right);

        if(r1 == true && r2 == true){
            return true;
        }
        return false;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean val = fun(p,q);
        return val;
    }
}