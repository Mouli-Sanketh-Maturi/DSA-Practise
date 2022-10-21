class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1)
            return strs[0];
        char[] prefix = strs[0].toCharArray();
        int endIndex = prefix.length - 1;
        for(String str : strs) {
            char[] strChars = str.toCharArray();
            if(strChars.length == 0)
                return "";
            int tempEndIndex = -1;
            for(int i=0; i<= Math.min(endIndex, strChars.length-1); i++) {
                if(strChars[i] == prefix[i]) {
                    tempEndIndex = i;
                } else {
                    break;
                }
            }
            endIndex = tempEndIndex;
        }
        if(endIndex < 0)
            return "";
        return new String(prefix,0,endIndex+1);
    }
}