class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int maxFactor =0;
        int minPrice = Integer.MAX_VALUE;

        //Find maximum factor and minimum price
        for(int []item : items){
            maxFactor = Math.max(maxFactor , item[0]);
            minPrice = Math.min(minPrice , item[1]);
        }

        //Find frequency of each factor
        int []freq = new int[maxFactor+1];
        for(int[] item : items){
            freq[item[0]]++;
        }

        //Copies obtained on first purchase
        int[] values = new int[n];
        for(int i=0; i<n; i++){
            int factor = items[i][0];
            int copies=0;

            //count divisible factors
            for(int multiple =factor; multiple<=maxFactor; multiple+=factor){
                copies += freq[multiple];
            }
            values[i] = copies;
        }


        // 0/1 knapsack
        int[] dp = new int[budget+1];
        Arrays.fill(dp,-1);
        dp[0]=0;

        for(int i=0; i<n; i++){
            int cost = items[i][1];
            for(int money = budget; money>=cost; money--){
                if(dp[money-cost]!=-1){
                    dp[money]= Math.max(dp[money],dp[money-cost]+values[i]);
                }
            }
        }
        
        int answer=0;
        //remaining budget
        for(int spent=0; spent<=budget; spent++){
            if(dp[spent]==-1){
                continue;
            }

            int remaining = budget-spent;
            int extra = remaining/minPrice;

            answer = Math.max(answer,dp[spent]+extra);
        }
        return answer;
    }
}