class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        Set<Character> currentChars = new HashSet<>();
        int prevIndex = -1;
        int maxSubString = 0;

        while(i < s.length()) {
            while(currentChars.contains(s.charAt(i))) {
                currentChars.remove(s.charAt(++prevIndex));
            }
            currentChars.add(s.charAt(i));
            maxSubString = Math.max(maxSubString, i - prevIndex);
            i++;
        }

        return maxSubString;
    }
}