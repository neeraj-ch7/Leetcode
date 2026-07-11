class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];      // larger index = stronger
            }
            return b[0] - a[0];          // more soldiers = stronger
        });

        for (int i = 0; i < mat.length; i++) {

            int soldiers = 0;

            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1)
                    soldiers++;
                else
                    break;
            }

            pq.offer(new int[]{soldiers, i});

            if (pq.size() > k)
                pq.poll();
        }

        int[] ans = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            ans[i] = pq.poll()[1];
        }

        return ans;
    }
}