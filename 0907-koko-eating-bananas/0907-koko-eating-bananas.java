class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 1;
        for(int pile : piles) {
            high = Math.max(pile, high);
        }

        int result = 0;

        while (low <= high) {
            int mid = (low+high)/2;
            int hours = 0;
            for(int pile : piles) {
                hours += Math.ceil((double) pile/mid);
            }
            if(hours <= h) {
                result = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return result;
    }
}