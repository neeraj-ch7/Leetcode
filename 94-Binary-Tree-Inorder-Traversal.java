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
   static void fun(TreeNode a, ArrayList<Integer> list){
    if(a==null){
        return;
    }
    fun(a.left,list);
    list.add(a.val);
    fun(a.right,list);
    return;

   }
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode a = root;
        ArrayList<Integer> list = new ArrayList<>();
        fun(a,list);
        return  list;
    }
}