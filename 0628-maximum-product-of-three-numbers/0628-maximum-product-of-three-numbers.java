class Solution {
    
    public int maximumProduct(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int max1 = nums[n-1]*nums[n-2]*nums[n-3];
        int max2 = nums[0]*nums[1]*nums[n-1];
        if(max1<max2){
            return max2;
        }
        else{
            return max1;
        }
        
        
    }
}