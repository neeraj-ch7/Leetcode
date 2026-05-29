1class Solution {
2
3       int fun(int n){
4            int sum =0;
5             while(n!=0){
6                int d= n%10;
7                n = n/10;
8                sum +=d*d;
9           }
10        return sum;
11       }
12
13    public boolean isHappy(int n) {
14
15     int slow= n;
16     int fast =n;
17     while(fast!=1){
18          
19          slow=fun(slow);
20          fast=fun(fast);
21          fast=fun(fast);
22        if(slow==fast && slow!=1){
23          return false;
24        }
25     }
26    return true;
27    }
28}