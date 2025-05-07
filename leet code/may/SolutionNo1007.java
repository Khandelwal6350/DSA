public class SolutionNo1007 {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        for (int x = 1; x <= 6; x++) {
            int rotations = check(x, tops, bottoms);
            if (rotations != -1) {
                return rotations;
            }
        }
        return -1;
    }

    private int check(int target, int[] tops, int[] bottoms) {
        int rotateTop = 0, rotateBottom = 0;
        for (int i = 0; i < tops.length; i++) {
            // If target is not present in either side, it's impossible
            if (tops[i] != target && bottoms[i] != target) {
                return -1;
            }
            // Count how many rotations needed for tops to have target
            if (tops[i] != target) rotateTop++;
            // Count how many rotations needed for bottoms to have target
            if (bottoms[i] != target) rotateBottom++;
        }
        return Math.min(rotateTop, rotateBottom);
    }
}
