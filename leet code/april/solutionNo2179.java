import java.util.*;

public class solutionNo2179 {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        
        // position[i] = index of i in nums2
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[nums2[i]] = i;
        }

        // mappedNums1[i] = index of nums1[i] in nums2
        int[] mappedNums1 = new int[n];
        for (int i = 0; i < n; i++) {
            mappedNums1[i] = pos[nums1[i]];
        }

        long[] left = new long[n];  // how many elements to the left are smaller
        long[] right = new long[n]; // how many elements to the right are greater

        FenwickTree bit = new FenwickTree(n);
        
        // Calculate left counts
        for (int i = 0; i < n; i++) {
            left[i] = bit.query(mappedNums1[i]);
            bit.update(mappedNums1[i], 1);
        }

        bit = new FenwickTree(n); // reset BIT

        // Calculate right counts
        for (int i = n - 1; i >= 0; i--) {
            right[i] = bit.query(n - 1) - bit.query(mappedNums1[i]);
            bit.update(mappedNums1[i], 1);
        }

        long res = 0;
        for (int i = 0; i < n; i++) {
            res += left[i] * right[i];
        }

        return res;
    }

    // Fenwick Tree implementation
    class FenwickTree {
        long[] tree;

        FenwickTree(int size) {
            tree = new long[size + 1];
        }

        void update(int index, int value) {
            index++;
            while (index < tree.length) {
                tree[index] += value;
                index += index & -index;
            }
        }

        long query(int index) {
            index++;
            long result = 0;
            while (index > 0) {
                result += tree[index];
                index -= index & -index;
            }
            return result;
        }
    }
}
