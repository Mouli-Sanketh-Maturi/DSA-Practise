class Solution {
    public int fib(int n) {
        Map<Integer,Integer> fbSeries = new HashMap<>();
        fbSeries.put(0,0);
        fbSeries.put(1,1);
        return fib(n,fbSeries);
    }
    
    int fib(int n, Map<Integer,Integer> fbSeries){
        if(fbSeries.get(n) != null){
            return fbSeries.get(n);
        }
        return fib(n-1,fbSeries) + fib(n-2,fbSeries);
    }
}