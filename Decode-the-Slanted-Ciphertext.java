1class Solution {
2    public String decodeCiphertext(String encodedText, int rows) {
3        if (rows == 0) return "";
4        
5        int n = encodedText.length();
6        int cols = n / rows;
7
8        // Step 1: Fill matrix
9        char[][] mat = new char[rows][cols];
10        int idx = 0;
11        
12        for (int i = 0; i < rows; i++) {
13            for (int j = 0; j < cols; j++) {
14                mat[i][j] = encodedText.charAt(idx++);
15            }
16        }
17
18        // Step 2: Read diagonals
19        StringBuilder result = new StringBuilder();
20
21        for (int startCol = 0; startCol < cols; startCol++) {
22            int i = 0, j = startCol;
23
24            while (i < rows && j < cols) {
25                result.append(mat[i][j]);
26                i++;
27                j++;
28            }
29        }
30
31        // Step 3: Remove trailing spaces
32        int end = result.length() - 1;
33        while (end >= 0 && result.charAt(end) == ' ') {
34            end--;
35        }
36
37        return result.substring(0, end + 1);
38    }
39}