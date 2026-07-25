class Solution {
    public boolean backspaceCompare(String s, String t) {

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        // Process s
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '#') {
                if (sb1.length() > 0) {
                    sb1.deleteCharAt(sb1.length() - 1);
                }
            } else {
                sb1.append(ch);
            }
        }

        // Process t
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);

            if (ch == '#') {
                if (sb2.length() > 0) {
                    sb2.deleteCharAt(sb2.length() - 1);
                }
            } else {
                sb2.append(ch);
            }
        }

        return sb1.toString().equals(sb2.toString());
    }
}