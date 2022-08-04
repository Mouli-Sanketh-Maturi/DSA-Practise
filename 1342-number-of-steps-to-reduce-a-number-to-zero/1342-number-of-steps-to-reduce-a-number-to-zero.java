class Solution {
    public int numberOfSteps(int num) {
        int numSteps = 0;
        while(num != 0){
            if(num%2 == 0){
                num = num/2;
                numSteps++;
            } else {
                num--;
                numSteps++;
            }
        }
        return numSteps;
    }
}