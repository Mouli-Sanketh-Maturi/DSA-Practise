class Solution {
    public void duplicateZeros(int[] arr) {
        for(int i=0;i<arr.length-1;i++){
            if(arr[i] == 0){
                shiftToRight(arr,i+1);
                arr[i+1]=0;
                i++;
            }
        }
    }
    
    public void shiftToRight(int[] arr, int idx){
        for(int i=(arr.length-2);i>=idx;i--){
            arr[i+1] = arr[i];
        }
    }
}