1class Solution {
2    public String generateString(String str1, String str2) {
3        int n = str1.length();
4        int m = str2.length();
5        int len = n + m - 1;
6
7        char[] word = new char[len];
8        boolean[] fixed = new boolean[len];
9
10        // Step 1: fill '?'
11        for (int i = 0; i < len; i++) {
12            word[i] = '?';
13        }
14
15        // Step 2: apply 'T'
16        for (int i = 0; i < n; i++) {
17            if (str1.charAt(i) == 'T') {
18                for (int j = 0; j < m; j++) {
19                    if (word[i + j] == '?' || word[i + j] == str2.charAt(j)) {
20                        word[i + j] = str2.charAt(j);
21                        fixed[i + j] = true; // mark fixed
22                    } else {
23                        return "";
24                    }
25                }
26            }
27        }
28
29        // Step 3: fill remaining with 'a'
30        for (int i = 0; i < len; i++) {
31            if (word[i] == '?') {
32                word[i] = 'a';
33            }
34        }
35
36        // Step 4: handle 'F'
37        for (int i = 0; i < n; i++) {
38            if (str1.charAt(i) == 'F') {
39                boolean match = true;
40
41                for (int j = 0; j < m; j++) {
42                    if (word[i + j] != str2.charAt(j)) {
43                        match = false;
44                        break;
45                    }
46                }
47
48                if (match) {
49                    boolean broken = false;
50
51                    // try to break using non-fixed positions
52                    for (int j = m - 1; j >= 0; j--) {
53                        if (!fixed[i + j]) {
54                            for (char c = 'a'; c <= 'z'; c++) {
55                                if (c != str2.charAt(j)) {
56                                    word[i + j] = c;
57                                    broken = true;
58                                    break;
59                                }
60                            }
61                        }
62                        if (broken) break;
63                    }
64
65                    if (!broken) return ""; // cannot break safely
66                }
67            }
68        }
69
70        return new String(word);
71    }
72}