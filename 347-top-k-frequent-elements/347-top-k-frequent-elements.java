class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            int freq = map.getOrDefault(num,0) + 1;
            map.put(num,freq);
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> {
            return map.get(b) - map.get(a);
        });
        for(int num : map.keySet()){
            heap.add(num);
        }
        int [] res = new int[k];
        for(int i=0; i<k; i++){
            res[i] = heap.poll();
        }
        return res;
    }
}