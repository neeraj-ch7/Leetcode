1class Solution {
2    public int numSpecial(int[][] mat) {
3
4        int m = mat.length;
5        int n = mat[0].length;
6
7        int[] row = new int[m];
8        int[] col = new int[n];
9
10        for(int i = 0; i < m; i++){
11            for(int j = 0; j < n; j++){
12                if(mat[i][j] == 1){
13                    ++row[i];
14                    ++col[j];
15                }
16            }
17        }
18
19        int count = 0;
20
21        for(int i = 0; i < m; i++){
22            for(int j = 0; j < n; j++){
23                if(mat[i][j] == 1 && row[i] == 1 && col[j] == 1){
24                    ++count;
25                }
26            }
27        }
28
29        return count;
30    }
31}