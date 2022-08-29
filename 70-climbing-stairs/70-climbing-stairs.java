class Solution {
    
    Map<Integer,Integer> ways2Climb = new HashMap<>();
    
    public int climbStairs(int n) {
        ways2Climb.put(0,0);
        ways2Climb.put(1,1);
        ways2Climb.put(2,2);
        return climbStair(n);
    }
    
    int climbStair(int n){
        if(n<0){
            return 0;
        }
        if(ways2Climb.containsKey(n)){
            return ways2Climb.get(n);
        }
        int sol =  climbStair(n-1)+climbStair(n-2);
        ways2Climb.put(n,sol);
        return sol;
    }
}