class Solution {
    public int minSumOfLengths(int[] arr, int target) {
     
        int n = arr.length;

        int[] best = new int[n];
        int INF = n + 1;

        for (int i = 0; i < n; i++) {
            best[i] = INF;
        }

        int left = 0;
        long sum = 0;
        int ans = INF;

        for (int right = 0; right < n; right++) {

            sum += arr[right];

           
            while (sum > target && left <= right) {
                sum -= arr[left];
                left++;
            }

           
            if (sum == target) {
                int len = right - left + 1;

             
                if (left > 0 && best[left - 1] != INF) {
                    ans = Math.min(ans, len + best[left - 1]);
                }

            
                if (right == 0) {
                    best[right] = len;
                } else {
                    best[right] = Math.min(best[right - 1], len);
                }
            } else {
              
                if (right > 0) {
                    best[right] = best[right - 1];
                }
            }
        }

        return ans == INF ? -1 : ans;
   
    }
}
