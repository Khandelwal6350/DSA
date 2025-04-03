class SolutionNo2874 {
    public long maximumTripletValue(int[] nums) {
        long maxTripletValue = 0;
        int maxDiff = 0; // max(nums[i] - nums[j])
        int maxLeft = 0; // max(nums[i])

        for (int num : nums) {
            maxTripletValue = Math.max(maxTripletValue, (long) maxDiff * num); // num represents nums[k]
            maxDiff = Math.max(maxDiff, maxLeft - num); // num represents nums[j]
            maxLeft = Math.max(maxLeft, num); // num represents nums[i]
        }

        return maxTripletValue;
    }
}

