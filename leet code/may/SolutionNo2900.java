import java.util.*;

class SolutionNo2900 {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        int prevGroup = -1;

        for (int i = 0; i < words.length; i++) {
            if (result.isEmpty() || groups[i] != prevGroup) {
                result.add(words[i]);
                prevGroup = groups[i];
            }
        }

        return result;
    }
}
