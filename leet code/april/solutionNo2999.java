public class solutionNo2999 {

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        long suffix = Long.parseLong(s);
        long suffixLength = s.length();
        long base = (long) Math.pow(10, suffixLength);

        long minNum = findMinNumber(start, suffix, base, limit);
        if (minNum == -1 || minNum > finish) {
            return 0;
        }

        long maxNum = findMaxNumber(finish, suffix, base, limit);
        if (maxNum == -1 || maxNum < start) {
            return 0;
        }

        return countValidNumbers(minNum, maxNum, base, limit);
    }

    private long findMinNumber(long start, long suffix, long base, int limit) {
        long num = (start / base) * base + suffix;
        if (num < start) {
            num += base;
        }
        while (!isValid(num, limit)) {
            num += base;
            if (num > Long.MAX_VALUE - base) {
                return -1;
            }
        }
        return num;
    }

    private long findMaxNumber(long finish, long suffix, long base, int limit) {
        long num = (finish / base) * base + suffix;
        if (num > finish) {
            num -= base;
        }
        while (!isValid(num, limit)) {
            num -= base;
            if (num < 0) {
                return -1;
            }
        }
        return num;
    }

    private boolean isValid(long num, int limit) {
        while (num > 0) {
            if (num % 10 > limit) {
                return false;
            }
            num /= 10;
        }
        return true;
    }

    private long countValidNumbers(long minNum, long maxNum, long base, int limit) {
        long count = 0;
        for (long num = minNum; num <= maxNum; num += base) {
            if (isValid(num, limit)) {
                count++;
            }
        }
        return count;
    }
}
