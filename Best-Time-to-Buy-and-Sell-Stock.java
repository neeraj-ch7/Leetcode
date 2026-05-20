1class Solution {
2    public int maxProfit(int[] prices) {
3
4        int minPrice = Integer.MAX_VALUE;
5        int maxProfit = 0;
6
7        for (int i = 0; i < prices.length; i++) {
8          
9            if (prices[i] < minPrice) {
10                minPrice = prices[i];
11            }
12
13            int profit = prices[i] - minPrice;
14
15            if (profit > maxProfit) {
16                maxProfit = profit;
17            }
18        }
19
20        return maxProfit;
21    }
22}