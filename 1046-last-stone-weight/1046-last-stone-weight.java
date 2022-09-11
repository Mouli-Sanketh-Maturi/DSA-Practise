class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) ->  b-a);
        for(int i=0; i<stones.length; i++)
            queue.add(stones[i]);
        while(queue.size() > 1){
            int stone1 = queue.poll();
            int stone2 = queue.poll();
            if(stone1 != stone2){
                queue.add(stone1 - stone2);
            }
        }
        if(queue.size() == 0){
            return 0;
        }
        return queue.poll();
    }
}