
import java.math.BigInteger;

class SolutionSum_of_all_substrings {
    public static BigInteger sumSubstrings(String num) {
        int n = num.length();
        BigInteger result = BigInteger.ZERO;
        BigInteger prev = BigInteger.ZERO;
        BigInteger ten = BigInteger.TEN;

        for (int i = 0; i < n; i++) {
            int digit = num.charAt(i) - '0';
            BigInteger digitBI = BigInteger.valueOf(digit);
            BigInteger iPlus1 = BigInteger.valueOf(i + 1);

            // curr = digit * (i + 1) + 10 * prev
            BigInteger curr = digitBI.multiply(iPlus1).add(ten.multiply(prev));
            result = result.add(curr);
            prev = curr;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "988924121";
        System.out.println(sumSubstrings(s));  // Should print: 1208583171
    }
}
