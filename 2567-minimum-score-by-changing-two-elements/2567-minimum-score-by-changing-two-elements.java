class Solution {
    public int minimizeSum(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min3 = Integer.MAX_VALUE;

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        for(int num:nums){
            if(num<min1){
                min3=min2;
                min2=min1;
                min1=num;
            }
            else if(num<min2){
                min3=min2;
                min2=num;
            }
            else if(num<min3){
                min3=num;
            }
            if(num>max1){
                max3=max2;
                max2=max1;
                max1=num;
            }
            else if(num>max2){
                max3=max2;
                max2=num;
            }
            else if(num>max3){
                max3=num;
            }
        }
        int score1,score2,score3;
        //case1:Replace min1 , min2 value by min3
        // a=min1;
        // b=min2;
        // c=min3;
        // d=max1;
        // a=c;
        // b=c;
        //low score always 0 so we find only high score
        score1=max1-min3;

        //case2:Replace min1 value by min2 and max1 by max2
        score2=max2-min2;

        //case3:Replace max1 and max2 value by max3
        score3=max3-min1;

        return Math.min(score1, Math.min(score2, score3));
        
        
    }
    
}