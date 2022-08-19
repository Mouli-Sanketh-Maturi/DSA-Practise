class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        String num = String.valueOf(x);
        char [] numChars = num.toCharArray();
        for(int i = 0; i < numChars.length; i++){
            int j = numChars.length - i -1;
            if(j < i){
                return true;
            }
            if(numChars[i] != numChars[j]){
                return false;
            }
        }
        return true;
    }
}