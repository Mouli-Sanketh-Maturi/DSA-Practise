class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> resultMap = new HashMap<>();
        for(String inp : strs){
            char [] hash = new char[26];
            char [] inpChars = inp.toCharArray();
            for(char inpChar : inpChars){
                hash[inpChar - 'a']++;
            }
            String hashStr = String.valueOf(hash);
            if(resultMap.containsKey(hashStr)){
                resultMap.get(hashStr).add(inp);
            } else {
                List<String> result = new ArrayList<>();
                result.add(inp);
                resultMap.put(hashStr,result);
            }
        }
        List<List<String>> resultList = new ArrayList<>();
        for(List<String> result : resultMap.values()){
            resultList.add(result);
        }
        return resultList;
    }
}