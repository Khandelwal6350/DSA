public class solutionNo2873 {
    public long maximumTripletValue(int[] nums) {
        long maxValue = 0;
        int maxDiff = 0; // max(nums[i] - nums[j])
        int maxNum = 0;  // max(nums[i])

        for (int num : nums) {
            maxValue = Math.max(maxValue, (long) maxDiff * num); 
            maxDiff = Math.max(maxDiff, maxNum - num);           
            maxNum = Math.max(maxNum, num);                     
        }

        return maxValue;
    }
}
