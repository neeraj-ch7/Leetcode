class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {


      
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            map.computeIfAbsent(row, k -> new HashSet<>()).add(col);
        }

  
        long ans = (long) (n - map.size()) * 2;

       
        for (int row : map.keySet()) {

            HashSet<Integer> seats = map.get(row);

            boolean left = true;   
            boolean middle = true; 
            boolean right = true;  

            for (int seat : seats) {

                if (seat >= 2 && seat <= 5) {
                    left = false;
                }

                if (seat >= 4 && seat <= 7) {
                    middle = false;
                }

                if (seat >= 6 && seat <= 9) {
                    right = false;
                }
            }

            if (left && right) {
                ans += 2;
            } 
            else if (left || middle || right) {
                ans += 1;
            }
        }

        return (int) ans;


    }
}