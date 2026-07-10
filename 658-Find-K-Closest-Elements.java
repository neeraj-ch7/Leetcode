class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
         (a,b) -> {
            if(a[0]==b[0]){
                return b[1] - a[1];
            }
            return b[0] -a[0];
         }
         );

        for(int num : arr){
            int dist = Math.abs(num-x);
            pq.offer(new int[]{dist,num});

            if(pq.size()>k){
                pq.poll();
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while(!pq.isEmpty()){
            ans.add(pq.poll()[1]);
        }
        Collections.sort(ans);

        return ans;

    }
}