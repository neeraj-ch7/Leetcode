1import java.util.*;
2
3class Solution {
4    public int numSpecial(int[][] mat) {
5
6        int m = mat.length;
7        int n = mat[0].length;
8
9        int[] row = new int[m];
10        int[] col = new int[n];
11
12        for(int i = 0; i < m; i++){
13            for(int j = 0; j < n; j++){
14                if(mat[i][j] == 1){
15                    ++row[i];
16                    ++col[j];
17                }
18            }
19        }
20
21        int count = 0;
22
23        for(int i = 0; i < m; i++){
24            for(int j = 0; j < n; j++){
25                if(mat[i][j] == 1 && row[i] == 1 && col[j] == 1){
26                    ++count;
27                }
28            }
29        }
30
31        return count;
32    }
33}