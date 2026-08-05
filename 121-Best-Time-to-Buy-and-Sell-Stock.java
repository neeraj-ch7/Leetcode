import java.util.Arrays;

class Solution {
    public int maxProfit(int[] prices) {
        int minP =Integer.MAX_VALUE;
        int maxPro =  0;

        for(int i =0;i<prices.length;i++){
            if(minP > prices[i]){
                minP = prices[i];
            }
            int profit =  prices[i] - minP;

            if(profit> maxPro){
                maxPro = profit;
            }
        }
        return maxPro;
    }
}