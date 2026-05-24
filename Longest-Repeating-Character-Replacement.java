1class Solution {
2 
3    int find(int[] a){
4     int   maxc=-1;
5        for(int i =0;i<256;i++){
6            maxc= Math.max(maxc,a[i]);
7        }
8        return maxc;
9    }
10    public int characterReplacement(String s, int k) {
11         
12          int[] f= new int[256];
13          int n= s.length();
14          int low=0, high=0, res=Integer.MIN_VALUE;
15
16          for(high =0;high<n;high++){
17            f[s.charAt(high)]++;
18             int maxcnt = find(f);
19             int len = high - low + 1;
20             int diff = len -maxcnt;
21
22             while (diff>k){
23                f[s.charAt(low)]--;
24                low++;
25                 maxcnt = find(f);
26                len = high - low + 1;
27                diff = len -maxcnt;
28             }
29             len = high -low +1;
30             res=Math.max(res,len);
31          }
32          return res;
33    }
34}