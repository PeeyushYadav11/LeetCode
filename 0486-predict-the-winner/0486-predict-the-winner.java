class Solution {
    public boolean predictTheWinner(int[] nums) {
        Integer[][]memo = new Integer[nums.length][nums.length];
        return maxDiff(nums, 0 ,nums.length-1, memo)>=0;
    }

    private int maxDiff(int[]nums, int left, int right, Integer[][] memo){
        if(left==right) return nums[left];
        if(memo[left][right]!= null ) return memo[left][right];

        int pickLeft = nums[left]-maxDiff(nums, left+1, right, memo);
        int pickRight = nums[right]-maxDiff(nums, left, right-1, memo);

        memo[left][right]= Math.max(pickLeft, pickRight);
        return memo[left][right];
    }
}