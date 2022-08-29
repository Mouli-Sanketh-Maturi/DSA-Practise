class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> indices = new ArrayList<>();
        char alp[] = new char [26];
        char[] inputString = s.toCharArray();
        char[] searchString = p.toCharArray();
        for(int i=0; i<searchString.length; i++){
            alp[searchString[i] - 'a']++;
        }
        String repString = String.valueOf(alp);
        alp = new char[26];
        for(int i=0;i<inputString.length;i++){
            alp[inputString[i] - 'a']++;
            if(i >= searchString.length){
                alp[inputString[i - searchString.length] - 'a']--;
            }
            if(i >= searchString.length-1){
                String currString = String.valueOf(alp);
                if(currString.equals(repString)){
                    indices.add(i - searchString.length +1);
                }
            }
        }
        return indices;
    }
}