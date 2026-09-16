class Solution {
    public boolean uniformArray(int[] nums1) {

        int min = nums1[0];

        boolean hasOdd = false;
        boolean hasEven = false;

        for (int x : nums1) {

            if (x % 2 == 0) {
                hasEven = true;
            } else {
                hasOdd = true;
            }

            if (x < min) {
                min = x;
            }
        }

        if (!hasOdd || !hasEven) {
            return true;
        }
       
        return min % 2 == 1;
    }
}
