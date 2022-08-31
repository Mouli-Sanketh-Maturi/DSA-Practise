class Solution {
    public int characterReplacement(String s, int k) {
        char[] arr = s.toCharArray();
        int maxCount = 0;
        for(int i=0; i<arr.length; i++){
            char match = arr[i];
            int missAllowed = k;
            int count = 0;
            for(int j=i; j<arr.length; j++){
                if(arr[j] != arr[i]){
                    missAllowed--;
                    if(missAllowed < 0){
                        break;
                    }
                }
                count = j-i+1;
            }
            if(missAllowed > 0){
                for(int j=i-1; j>=0; j--){
                    if(arr[j] != arr[i]){
                    missAllowed--;
                        if(missAllowed < 0){
                            break;
                        }
                    }
                    count += 1;
                }
            }
            if(count > maxCount){
                maxCount = count;
            }
        }
        return maxCount;
    }
}