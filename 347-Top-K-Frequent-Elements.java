import java.util.*;

class Solution {

    class Pair {
        int num;
        int freq;

        Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Store frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min Heap based on frequency
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.freq, b.freq)
        );

        // Step 3: Add first k pairs, then maintain heap size = k
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            Pair p = new Pair(entry.getKey(), entry.getValue());

            if (pq.size() < k) {
                pq.add(p);
            } else {

                if (p.freq > pq.peek().freq) {
                    pq.poll();
                    pq.add(p);
                }
            }
        }

        // Step 4: Store answer
        int[] ans = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            ans[i] = pq.poll().num;
        }

        return ans;
    }
}