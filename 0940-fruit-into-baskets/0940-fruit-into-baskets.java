

import static java.lang.Math.max;

class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0; // inclusive
        int right = 1; //exclusive
        Map<Integer, Integer> frequencyCount = new HashMap<>();
        int maxFruits = 0;
        while (right <= fruits.length) {
            if(!frequencyCount.containsKey(fruits[right-1])) {
                while (frequencyCount.size() >= 2) {
                    int leftFruitCount = frequencyCount.get(fruits[left]);
                    leftFruitCount--;
                    if(leftFruitCount == 0) {
                        frequencyCount.remove(fruits[left]);
                    } else {
                        frequencyCount.put(fruits[left], leftFruitCount);
                    }
                    left++;
                }
                frequencyCount.put(fruits[right-1], 0);
            }
            int rightFruitCount = frequencyCount.get(fruits[right-1]);
            rightFruitCount++;
            frequencyCount.put(fruits[right-1], rightFruitCount);
            maxFruits = Math.max(right - left, maxFruits);
            right++;
        }
        return maxFruits;
    }
}