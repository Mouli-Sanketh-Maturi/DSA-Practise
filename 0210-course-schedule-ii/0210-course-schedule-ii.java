class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> prerequisiteParentMapping = new HashMap<>();
        int[] prerequisiteFrequency = new int[numCourses];
        int[] finishOrder = new int[numCourses];
        for(int[] prerequisite : prerequisites) {
            List<Integer> prerequisiteSet = prerequisiteParentMapping.getOrDefault(prerequisite[1], new ArrayList<>());
            prerequisiteSet.add(prerequisite[0]);
            prerequisiteParentMapping.put(prerequisite[1], prerequisiteSet);
            prerequisiteFrequency[prerequisite[0]]++;
        }

        Queue<Integer> finishableCourses = new LinkedList<>();
        for(int i=0; i<prerequisiteFrequency.length; i++) {
            if(prerequisiteFrequency[i] == 0) {
                finishableCourses.add(i);
            }
        }

        int finishedCourseCount = 0;

        while(!finishableCourses.isEmpty()) {
            int courseNumber = finishableCourses.poll();
            finishOrder[finishedCourseCount++] = courseNumber;
            for(int prerequisiteParentCourseNumber : prerequisiteParentMapping.getOrDefault(courseNumber, new ArrayList<>())) {
                prerequisiteFrequency[prerequisiteParentCourseNumber]--;
                if(prerequisiteFrequency[prerequisiteParentCourseNumber] == 0) {
                    finishableCourses.add(prerequisiteParentCourseNumber);
                }
            }
        }

        if(finishedCourseCount < numCourses) { return new int[0];}

        return finishOrder;
        
    }
}