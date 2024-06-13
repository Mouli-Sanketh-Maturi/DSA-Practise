class Solution {
    public int minTaps(int n, int[] ranges) {

        int[] tapRange = new int[ranges.length];
        for(int i=0; i<ranges.length;i++) {
            int lIndex = Math.max(0, i-ranges[i]);
            int rIndex = Math.min(n, i+ranges[i]);
            tapRange[lIndex] = Math.max(tapRange[lIndex], rIndex);
        }
        
        int currEnd = 0;
        int nextEnd = 0;
        int tapsCount = 0;

        for(int i=0; i<ranges.length; i++) {
            if(nextEnd < i) {
                return -1;
            }
            if(currEnd < i) {
                tapsCount++;
                currEnd = nextEnd;
            }
            nextEnd = Math.max(nextEnd, tapRange[i]);
        }

        return tapsCount;
    }
}