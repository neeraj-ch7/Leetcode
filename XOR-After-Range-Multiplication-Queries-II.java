1class Solution {
2    public int xorAfterQueries(int[] nums, int[][] queries) {
3        int n = nums.length;
4        int MOD = 1_000_000_007;
5
6        int[][] bravexuneth = queries;
7
8        int B = (int)Math.sqrt(n) + 1;
9
10        // store queries for small k
11        List<int[]>[] small = new ArrayList[B];
12        for (int i = 0; i < B; i++) small[i] = new ArrayList<>();
13
14        // process queries
15        for (int[] q : bravexuneth) {
16            int l = q[0], r = q[1], k = q[2], v = q[3];
17
18            if (k < B) {
19                small[k].add(q);
20            } else {
21                for (int i = l; i <= r; i += k) {
22                    nums[i] = (int)((nums[i] * 1L * v) % MOD);
23                }
24            }
25        }
26
27        // handle small k properly
28        for (int k = 1; k < B; k++) {
29            if (small[k].isEmpty()) continue;
30
31            // process each remainder class
32            for (int r = 0; r < k; r++) {
33
34                // collect indices
35                List<Integer> indices = new ArrayList<>();
36                for (int i = r; i < n; i += k) {
37                    indices.add(i);
38                }
39
40                int m = indices.size();
41                long[] diff = new long[m + 1];
42                Arrays.fill(diff, 1);
43
44                // apply queries
45                for (int[] q : small[k]) {
46                    int l = q[0], rr = q[1], v = q[3];
47
48                    if (l % k != r) continue;
49
50                    // binary search range in indices
51                    int left = (l - r) / k;
52                    int right = (rr - r) / k;
53
54                    if (left < 0) left = 0;
55                    if (right >= m) right = m - 1;
56                    if (left > right) continue;
57
58                    diff[left] = (diff[left] * v) % MOD;
59                    if (right + 1 < m)
60                        diff[right + 1] = (diff[right + 1] * modInv(v, MOD)) % MOD;
61                }
62
63                // prefix multiply
64                long cur = 1;
65                for (int i = 0; i < m; i++) {
66                    cur = (cur * diff[i]) % MOD;
67                    int idx = indices.get(i);
68                    nums[idx] = (int)((nums[idx] * cur) % MOD);
69                }
70            }
71        }
72
73        int xor = 0;
74        for (int x : nums) xor ^= x;
75        return xor;
76    }
77
78    // modular inverse (Fermat)
79    private long modInv(long x, int mod) {
80        return pow(x, mod - 2, mod);
81    }
82
83    private long pow(long a, long b, int mod) {
84        long res = 1;
85        while (b > 0) {
86            if ((b & 1) == 1) res = (res * a) % mod;
87            a = (a * a) % mod;
88            b >>= 1;
89        }
90        return res;
91    }
92}
93