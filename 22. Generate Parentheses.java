class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        backtrack("", 0, 0, n, ans);

        return ans;
    }

    public void backtrack(String str, int open, int close,
                           int n, List<String> ans) {

       
        if (open == n && close == n) {
            ans.add(str);
            return;
        }

        
        if (open < n) {
            backtrack(str + "(", open + 1, close, n, ans);
        }

        
        if (close < open) {
            backtrack(str + ")", open, close + 1, n, ans);
        }
    }
}
