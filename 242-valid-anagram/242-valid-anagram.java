class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        char [] firstString = s.toLowerCase().toCharArray();
        char [] secondString = t.toLowerCase().toCharArray();
        int [] arr = new int [26];
        for(int i=0;i<firstString.length;i++){
            arr[firstString[i]-'a']++;
            arr[secondString[i]-'a']--;
        }
        for(int i=0;i<26;i++){
            if(arr[i] != 0){
                return false;
            }
        }
        return true;
    }
}