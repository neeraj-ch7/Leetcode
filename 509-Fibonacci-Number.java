class Solution {
    int fun(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        int ans1 = fun(n-1);
        int ans2 = fun(n-2);
        return ans1 +ans2;
    }
    public int fib(int n) {
        return fun(n);
    }
}