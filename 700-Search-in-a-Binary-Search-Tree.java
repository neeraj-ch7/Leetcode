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
    TreeNode ans = null;

    void fun(TreeNode r,int k){
        if(r == null){
            return;
        }
        if(r.val == k){
            ans=r;
        }

        if(r.val > k ){
            fun(r.left,k);
        }else{
            fun(r.right,k);
        }

    }

    public TreeNode searchBST(TreeNode root, int val) {
        fun(root,val);
        return ans;
    }
}