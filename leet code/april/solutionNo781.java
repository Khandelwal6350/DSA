import java.util.HashMap;
import java.util.Map;

public class solutionNo781 {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> countMap = new HashMap<>();
        
        // Count the frequency of each answer
        for (int answer : answers) {
            countMap.put(answer, countMap.getOrDefault(answer, 0) + 1);
        }

        int result = 0;
        
        // For each distinct answer, calculate the required number of rabbits
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int answer = entry.getKey();
            int freq = entry.getValue();
            
            // Number of groups of size (answer + 1)
            result += ((freq + answer) / (answer + 1)) * (answer + 1);
        }

        return result;
    }
}
