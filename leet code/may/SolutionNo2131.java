import java.util.HashMap;
import java.util.Map;

public class SolutionNo2131 {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int length = 0;
        boolean hasMiddle = false;

        for (String word : words) {
            String reversed = new StringBuilder(word).reverse().toString();

            if (map.getOrDefault(reversed, 0) > 0) {
                // A reverse pair exists
                length += 4;
                map.put(reversed, map.get(reversed) - 1);
            } else {
                // Store the word for future matching
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        // Check for a possible central palindromic word (like "gg")
        for (String key : map.keySet()) {
            if (key.charAt(0) == key.charAt(1) && map.get(key) > 0) {
                hasMiddle = true;
                break;
            }
        }

        return hasMiddle ? length + 2 : length;
    }
}
