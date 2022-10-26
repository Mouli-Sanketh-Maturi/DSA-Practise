public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int one = 1;
        int count = 0;
        while(n != 0) {
            if((n & one) != 0) {
                count ++;
            }
            n = n >>> 1;
        }
        return count;
    }
}