class Solution {
    public boolean isPalindrome(String s) {
        char[] inp = s.toCharArray();
        int length = inp.length;
        int i = 0;
        int j = length-1;
        while(i < j) {
            if(!Character.isLetterOrDigit(inp[i])) {
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(inp[j])) {
                j--;
                continue;
            }
            if(Character.toLowerCase(inp[i]) != Character.toLowerCase(inp[j])) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}