class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i,j) -> Integer.compare(i[0],j[0]));

        List<int[]> finalIntervals = new ArrayList<>(); 
        int[] prevInterval = intervals[0];

        for(int[] interval : intervals) {
            if(interval[0] <= prevInterval[1]) {
                prevInterval[1] = Integer.max(interval[1],prevInterval[1]);
            } else {
                finalIntervals.add(prevInterval);
                prevInterval = interval;
            }
        }

        finalIntervals.add(prevInterval);

        return finalIntervals.toArray(new int[finalIntervals.size()][]);

    }
}