class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> {
            return a[0]-b[0];
        });
        for(int i=0; i<meetings.length-1; i++) {
            if(meetings[i][1] >= meetings[i+1][0]) {
                meetings[i+1][0] = Math.min(meetings[i][0], meetings[i+1][0]);
                meetings[i+1][1] = Math.max(meetings[i][1], meetings[i+1][1]);
            }  else {
                days -= (meetings[i][1] - meetings[i][0] + 1);
            }
        }
        days -= (meetings[meetings.length-1][1] - meetings[meetings.length-1][0] + 1);
        
        return days;
    }
}