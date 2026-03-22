1class Solution {
2
3    void rotate(int[][] mat){
4        int n = mat.length;
5        int[][] temp = new int[n][n];
6
7        for(int i=0;i<n;i++){
8            for(int j=0;j<n;j++){
9                temp[i][j] = mat[j][n-i-1];
10            }
11        }
12
13        for(int i=0;i<n;i++){
14            for(int j=0;j<n;j++){
15                mat[i][j] = temp[i][j];
16            }
17        }
18    }
19
20    public boolean findRotation(int[][] mat, int[][] target) {
21        for(int i=0;i<4;i++){
22            if(Arrays.deepEquals(mat, target)) return true;
23            rotate(mat);
24        }
25        return false;
26    }
27
28    
29}
30
31