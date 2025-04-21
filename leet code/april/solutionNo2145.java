class solutionNo2145 {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long min = 0, max = 0, sum = 0;
        for (int diff : differences) {
            sum += diff;
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }

        long minStart = lower - min;
        long maxStart = upper - max;

        return (int)Math.max(0, maxStart - minStart + 1);
    }
}
