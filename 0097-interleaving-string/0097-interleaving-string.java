class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int[][] memo = new int[s1.length()+1][s2.length()+1];
        for(int i=0 ;i<=s1.length(); i++) {
            Arrays.fill(memo[i],-1);
        }
        return isMerge(s1, s2, s3, 0, 0, 0, memo);
    }

    public boolean isMerge(String s1, String s2, String s3, int i, int j, int k, int[][] memo) {
        if(k == s3.length()) {
            if(s1.length() == i && s2.length() == j) {
                return true;
            }
            return false;
        }
        if(memo[i][j] != -1) {
            return memo[i][j] == 1;
        }
        
        Boolean isMerge = false;
        if(i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            isMerge = isMerge || isMerge(s1, s2, s3, i+1, j, k+1, memo);
        }

        if(j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            isMerge = isMerge || isMerge(s1, s2, s3, i, j+1, k+1, memo);
        }

        memo[i][j] = isMerge ? 1 : 0;
        return isMerge;

    }
}