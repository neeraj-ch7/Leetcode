class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row = matrix.length-1;
        int n = matrix[0].length;
        int col = 0;

        while(row>=0 && col < n ){
             
             int guess = matrix[row][col];
             if(guess == target){
                return true;
             }
             if(guess > target){
                row--;
             }else{
                col++;
             }
        }
        return false;

    }
}