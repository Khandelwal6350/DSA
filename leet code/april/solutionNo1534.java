public class solutionNo1534 {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        int n = arr.length;

      
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (Math.abs(arr[i] - arr[j]) <= a) {
                    for (int k = j + 1; k < n; k++) {
                        if (Math.abs(arr[j] - arr[k]) <= b &&
                            Math.abs(arr[i] - arr[k]) <= c) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }

   
    public static void main(String[] args) {
        solutionNo1534 sol = new solutionNo1534(); 
        int[] arr = {3, 0, 1, 1, 9, 7};
        int a = 7, b = 2, c = 3;
        int result = sol.countGoodTriplets(arr, a, b, c);
        System.out.println("Good triplets count: " + result); 
    }
}
