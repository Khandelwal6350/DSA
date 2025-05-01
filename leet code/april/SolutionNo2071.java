import java.util.*;

public class SolutionNo2071 {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int left = 0, right = Math.min(tasks.length, workers.length);

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canAssign(tasks, workers, pills, strength, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    private boolean canAssign(int[] tasks, int[] workers, int pills, int strength, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = k - 1; i >= 0; i--) {
            dq.addFirst(tasks[i]);
        }

        TreeMap<Integer, Integer> multiset = new TreeMap<>();
        for (int i = workers.length - k; i < workers.length; i++) {
            multiset.put(workers[i], multiset.getOrDefault(workers[i], 0) + 1);
        }

        for (int i = 0; i < k; i++) {
            int task = dq.removeLast();

            // Try to find a worker who can do it without a pill
            Integer worker = multiset.ceilingKey(task);
            if (worker != null) {
                removeWorker(multiset, worker);
                continue;
            }

            // Use pill on weakest possible worker who can now do the task
            worker = multiset.ceilingKey(task - strength);
            if (worker != null && pills > 0) {
                removeWorker(multiset, worker);
                pills--;
            } else {
                return false;
            }
        }

        return true;
    }

    private void removeWorker(TreeMap<Integer, Integer> multiset, int key) {
        if (multiset.get(key) == 1) {
            multiset.remove(key);
        } else {
            multiset.put(key, multiset.get(key) - 1);
        }
    }

    // Main method to test the solution
    public static void main(String[] args) {
        SolutionNo2071 sol = new SolutionNo2071();

        int[] tasks = {3, 2, 1};
        int[] workers = {0, 3, 3};
        int pills = 1;
        int strength = 1;

        int result = sol.maxTaskAssign(tasks, workers, pills, strength);
        System.out.println("Maximum tasks assigned: " + result);  // Expected output: 3
    }
}
