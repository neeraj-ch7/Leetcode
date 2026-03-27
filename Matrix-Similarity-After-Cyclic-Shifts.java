1class Solution {
2    public boolean areSimilar(int[][] mat, int k) {
3        int m = mat.length;
4        int n = mat[0].length;
5
6        int shift = k % n; // important optimization
7
8        for (int i = 0; i < m; i++) {
9            for (int j = 0; j < n; j++) {
10
11                if (i % 2 == 0) {
12                    // even row → left shift
13                    if (mat[i][j] != mat[i][(j + shift) % n]) {
14                        return false;
15                    }
16                } else {
17                    // odd row → right shift
18                    if (mat[i][j] != mat[i][(j - shift + n) % n]) {
19                        return false;
20                    }
21                }
22
23            }
24        }
25
26        return true;
27    }
28}