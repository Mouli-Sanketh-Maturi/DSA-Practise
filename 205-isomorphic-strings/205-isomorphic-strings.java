class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> charMapping = new HashMap<>();
        for(int i=0; i<s.length();i++){
            if(charMapping.containsKey(s.charAt(i))){
                if(charMapping.get(s.charAt(i)) != t.charAt(i)){
                    return false;
                }
            } else {
                if(charMapping.containsValue(t.charAt(i))){
                    return false;
                }
                charMapping.put(s.charAt(i),t.charAt(i));
            }
        }
        return true;
    }
}