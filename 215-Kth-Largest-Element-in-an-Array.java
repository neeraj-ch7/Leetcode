class Solution {
    public int findKthLargest(int[] nums, int k) {

        // Code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0;i<k;i++){
            pq.add(nums[i]);
        }
        
        int  n = nums.length;
        
        int i = k;
        
        while(i<n){
            if(nums[i]>pq.peek()){
                pq.add(nums[i]);
                pq.remove();
                i++;
            }else{
                i++;
            }
        }
        return pq.peek();
    }
}