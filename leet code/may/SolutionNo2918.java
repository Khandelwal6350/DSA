public class SolutionNo2918 {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        int zeroCount1 = 0, zeroCount2 = 0;

        for (int num : nums1) {
            if (num == 0) {
                zeroCount1++;
                sum1 += 1; // Replace zero with minimum positive integer
            } else {
                sum1 += num;
            }
        }

        for (int num : nums2) {
            if (num == 0) {
                zeroCount2++;
                sum2 += 1; // Replace zero with minimum positive integer
            } else {
                sum2 += num;
            }
        }

        if ((sum1 < sum2 && zeroCount1 == 0) || (sum2 < sum1 && zeroCount2 == 0)) {
            return -1;
        }

        return Math.max(sum1, sum2);
    }
}
