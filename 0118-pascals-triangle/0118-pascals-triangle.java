class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> pascalsTriangle = new ArrayList<List<Integer>>();
        
        List<Integer> firstRow = new ArrayList<Integer>();
        firstRow.add(1);
        pascalsTriangle.add(firstRow);

        for(int i=1; i<numRows; i++) {
            List<Integer> currentRow = new ArrayList<Integer>();
            currentRow.add(1);

            for(int j=1; j<i;j++) {
                currentRow.add(pascalsTriangle.get(i-1).get(j-1) + pascalsTriangle.get(i-1).get(j));
            }

            currentRow.add(1);
            pascalsTriangle.add(currentRow);
        }

        return pascalsTriangle;
        
    }
}