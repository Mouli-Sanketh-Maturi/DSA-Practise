class Solution {
    public double myPow(double x, int n) {
        if(n < 0) {
            return 1/pow(x,n);
        }
        return pow(x,n);
    }

    public double pow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if(n == 1) {
            return x;
        }
        double prod = pow(x,n/2);
        if(n%2 == 0) {
            return prod * prod;
        }
        return prod * prod * x;
    }

}