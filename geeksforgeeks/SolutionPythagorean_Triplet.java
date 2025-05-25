import java.util.HashSet;

public class SolutionPythagorean_Triplet {

    public static boolean pythagoreanTriplet(int[] arr) {
        HashSet<Integer> squares = new HashSet<>();

        // Store squares of all numbers
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];
            squares.add(arr[i]);
        }

        // Try every pair (a^2 + b^2), check if it's in the set
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (squares.contains(sum)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 6, 5};

        if (pythagoreanTriplet(arr))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
