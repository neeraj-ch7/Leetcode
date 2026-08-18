class Solution {
    
    boolean fun(TreeNode r1, TreeNode r2) {
        
        if (r1 == null && r2 == null) {
            return true;
        }

        if (r1 == null || r2 == null) {
            return false;
        }

        if (r1.val != r2.val) {
            return false;
        }

        return fun(r1.left, r2.left) &&
               fun(r1.right, r2.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
         
        if (root == null) {
            return false;
        }

        if (fun(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) ||
               isSubtree(root.right, subRoot);
    }
}