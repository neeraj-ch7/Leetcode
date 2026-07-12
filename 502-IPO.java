class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
       
        int[][] pairs = new int[capital.length][2];
       
        for(int i =0;i<capital.length;i++){
            pairs[i][0] =capital[i];
            pairs[i][1] =profits[i];
        }
        Arrays.sort(pairs, (a,b)-> {
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });
        int i = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while(k!=0){
            while(i<capital.length){
                if(pairs[i][0]>w){
                    break;
                }
                pq.add(pairs[i][1]);
                i++;
                }
                if(pq.isEmpty()){
                    return w;
                }
                w = w + pq.peek();
                pq.remove();
            
            k--;
        }
        return w;
    }
}