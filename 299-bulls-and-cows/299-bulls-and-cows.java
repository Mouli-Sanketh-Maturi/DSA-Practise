class Solution {
    public String getHint(String secret, String guess) {
        char[] secretChar = secret.toCharArray();
        char[] guessChar = guess.toCharArray();
        int bullCount = 0;
        int cowCount = 0;
        Map<Character,Integer> secretMap = new HashMap<>();
        for(int i=0; i<secretChar.length; i++){
            if(secretChar[i] == guessChar[i]){
                bullCount++;
                guessChar[i] = 'a';
            } else {
                if(secretMap.containsKey(secretChar[i])){
                    secretMap.put(secretChar[i],secretMap.get(secretChar[i])+1);
                } else {
                    secretMap.put(secretChar[i],1);
                }
            }
        }
        for(char c: guessChar){
            if(secretMap.containsKey(c) && secretMap.get(c) > 0){
                cowCount++;
                secretMap.put(c,secretMap.get(c)-1);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bullCount);
        sb.append("A");
        sb.append(cowCount);
        sb.append("B");
        return sb.toString();
    }
}