import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency
        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int freq : map.values()) {
            pq.offer(freq);
        }

        int time = 0;

        while (!pq.isEmpty()) {

            List<Integer> temp = new ArrayList<>();

            int cycle = n + 1;

            while (cycle > 0 && !pq.isEmpty()) {

                int freq = pq.poll();

                freq--;

                if (freq > 0)
                    temp.add(freq);

                time++;
                cycle--;
            }

            // Push remaining tasks back
            for (int f : temp)
                pq.offer(f);

            // If heap is empty, no idle time needed
            if (pq.isEmpty())
                break;

            // Add idle time
            time += cycle;
        }

        return time;
    }
}