class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> domainCount = new HashMap<>();
        List<String> result = new ArrayList<>();
        for(String cpdomain : cpdomains) {
            String[] arr = cpdomain.split(" ");
            int count = Integer.valueOf(arr[0]);
            while(true) {
                int domainFreq = domainCount.getOrDefault(arr[1], 0);
                domainFreq += count;
                domainCount.put(arr[1], domainFreq);
                String[] temp = arr[1].split("\\.",2);
                if(temp.length < 2) {
                    break;
                }
                arr=temp;
            }
        }
        for(String key : domainCount.keySet()) {
            int count = domainCount.get(key);
            result.add(count + " " + key);
        }
        return result;
    }
}