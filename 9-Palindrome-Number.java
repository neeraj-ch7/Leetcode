class Solution {
    boolean fun(String s,int low , int high){
        int len = high -low +1;
        if(len ==0 || len ==1){
            return true;
        }
        if(s.charAt(low) != s.charAt(high)){
            return false;
        }
      return  fun(s,low+1,high-1);
      
    }
    public boolean isPalindrome(int x) {
      
        String s = String.valueOf(x);
        int low = 0;
        int high = s.length()-1;

        return fun(s,low,high);
    }
}