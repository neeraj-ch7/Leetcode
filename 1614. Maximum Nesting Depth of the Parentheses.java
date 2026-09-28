class Solution {
    public int maxDepth(String s) {
        int current = 0;
        int maxDepth = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                current++;
                maxDepth = Math.max(maxDepth, current);
            } 
            else if (s.charAt(i) == ')') {
                current--;
            }
        }

        return maxDepth;
    }
}
