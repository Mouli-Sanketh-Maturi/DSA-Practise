class Solution {
    public char repeatedCharacter(String s) {
        Set<Character> charCheck = new HashSet<>();
        for(int i=0; i<s.length(); i++){
            if(charCheck.contains(s.charAt(i))){
                return s.charAt(i);
            }
            charCheck.add(s.charAt(i));
        }
        return 'a';
    }
}