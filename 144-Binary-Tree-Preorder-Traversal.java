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
    static void pre(TreeNode a, ArrayList<Integer> list){
        if(a!=null){
            list.add(a.val);
            pre(a.left,list);
            pre(a.right,list);
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
       ArrayList<Integer> list = new ArrayList<>();
       pre(root,list);
       return list; 
    }
}