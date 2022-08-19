class Solution {
    public int longestPalindrome(String s) {
        int [] smallLetters = new int[26];
        int [] capLetters = new int[26];
        char [] inpString = s.toCharArray();
        int palLength = 0;
        int extraChar = 0;
        for(char inp : inpString){
            if(inp >= 'a' && inp <= 'z'){
                smallLetters[inp - 'a']++;
            } else {
                capLetters[inp - 'A']++;
            }
        }
        
        for(int count : smallLetters){
            if(count % 2 == 0){
                palLength += count;
            } else if(count > 1) {
                palLength += (count - count%2);
                extraChar++;
            } else {
                extraChar += count;
            }
        }
        
        for(int count : capLetters){
            if(count % 2 == 0){
                palLength += count;
            } else if(count > 1) {
                palLength += (count - count%2);
                extraChar++;
            } else {
                extraChar += count;
            }
        }
        
        if(extraChar >0){
            palLength++;
        }
        return palLength;
    }
}