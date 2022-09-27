class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        char [] charArray = s.toCharArray();
        int low = 0;
        int maxLength = 0;
        for(int high = 0; high<charArray.length; high++){
            if(charSet.contains(charArray[high])){
                if(high-low > maxLength){
                    maxLength = high-low;
                }
                while(charArray[low] != charArray[high]){
                    charSet.remove(charArray[low]);
                    low++;
                }
                low++;
            } else {
                if(high-low >= maxLength){
                    maxLength = high-low+1;
                }
            }
            charSet.add(charArray[high]);
        }
        return maxLength;
    }
}