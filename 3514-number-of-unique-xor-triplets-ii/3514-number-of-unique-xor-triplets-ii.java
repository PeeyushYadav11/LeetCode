class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        Set <Integer> S1 = new HashSet<>();
        for(int i = 0; i<n; i++){
            for(int j =i; j<n; j++){
                int val = (nums[i] ^ nums[j]);
                if (S1.contains(val)){
                    continue;
                }
                else{
                    S1.add(val);
                }
                
            }
        }
        Set <Integer> UniqueValue = new HashSet<>();
        for( int ele : S1){
            for(int i =0; i<n; i++){
                int val = (ele ^ nums[i]);
                if (UniqueValue.contains(val)){
                    continue;
                }
                else{
                    UniqueValue.add(val);
                }
            }

        }
        return UniqueValue.size();
        
    }
}