class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list =  new ArrayList<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            list.add(nums[i]);

        } 
        int min = Collections.min(list);
        int max = Collections.max(list);

        List<Integer> l2 = new ArrayList<>();

        for(int i=min; i<=max; i++){
            if(list.contains(i)){
                continue;
            }
            else{
                l2.add(i);
            }
        }

        return l2;
    }
}