import java.util.*;

public class SolutionNo2094 {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set = new TreeSet<>();

        int n = digits.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (j == i) continue;
                for (int k = 0; k < n; ++k) {
                    if (k == i || k == j) continue;

                    int d1 = digits[i];
                    int d2 = digits[j];
                    int d3 = digits[k];

                    if (d1 == 0) continue; // no leading 0
                    if (d3 % 2 != 0) continue; // must be even

                    int num = d1 * 100 + d2 * 10 + d3;
                    set.add(num);
                }
            }
        }

        // Convert to int[]
        int[] res = new int[set.size()];
        int idx = 0;
        for (int num : set) {
            res[idx++] = num;
        }

        return res;
    }
}
