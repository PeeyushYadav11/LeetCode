class Solution {
    public int uniqueXorTriplets(int[] nums) {

        int n = nums.length;
        if(n<3){
            return n;
        }
        int i= 2;
        while(Math.pow(2,i)<=n){
            i++;
        }
        int k = (int) Math.pow(2,i);
        return k ;
        
    }
}