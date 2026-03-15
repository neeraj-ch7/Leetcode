1import java.util.*;
2
3class Fancy {
4
5    long MOD = 1000000007;
6    List<Long> list;
7    long mul;
8    long add;
9
10    public Fancy() {
11        list = new ArrayList<>();
12        mul = 1;
13        add = 0;
14    }
15
16    public void append(int val) {
17        long v = (val - add + MOD) % MOD;
18        v = (v * modInverse(mul)) % MOD;
19        list.add(v);
20    }
21
22    public void addAll(int inc) {
23        add = (add + inc) % MOD;
24    }
25
26    public void multAll(int m) {
27        mul = (mul * m) % MOD;
28        add = (add * m) % MOD;
29    }
30
31    public int getIndex(int idx) {
32        if (idx >= list.size()) return -1;
33        long val = list.get(idx);
34        long res = (val * mul) % MOD;
35        res = (res + add) % MOD;
36        return (int) res;
37    }
38
39    private long modInverse(long x) {
40        return modPow(x, MOD - 2);
41    }
42
43    private long modPow(long base, long exp) {
44        long res = 1;
45        base %= MOD;
46
47        while (exp > 0) {
48            if ((exp & 1) == 1) res = (res * base) % MOD;
49            base = (base * base) % MOD;
50            exp >>= 1;
51        }
52        return res;
53    }
54}
55/**
56 * Your Fancy object will be instantiated and called as such:
57 * Fancy obj = new Fancy();
58 * obj.append(val);
59 * obj.addAll(inc);
60 * obj.multAll(m);
61 * int param_4 = obj.getIndex(idx);
62 */