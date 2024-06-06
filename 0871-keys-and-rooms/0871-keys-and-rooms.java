class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> result = new HashSet<>();
        
        Queue<Integer> roomIndex = new LinkedList<>();
        roomIndex.offer(0);
        result.add(0);

        while (!roomIndex.isEmpty()) {
            int index = roomIndex.poll();
            result.addAll(rooms.get(index));
            roomIndex.addAll(rooms.get(index));
            rooms.set(index, new ArrayList<>());
        }



        return result.size() == rooms.size();
    }
}