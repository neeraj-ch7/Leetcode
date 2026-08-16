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
    TreeNode ans =null;

    int fun(TreeNode n,TreeNode p,TreeNode q){
        if(n== null){
            return 0;
        }
       int left= fun(n.left,p,q);
       int right= fun(n.right,p,q);
        int self= 0;
        if(n.val == p.val || n.val == q.val){
            self = 1;
        }
        int total = left + right + self;

        if(total == 2 && ans == null){
            ans = n;
        }
        return  total;  
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        fun(root,p,q);
        return ans;
    }
}