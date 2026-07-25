class Solution {
    public int maxProduct(int n) {
        List <Integer> arr = new ArrayList<>();

        while(n>0){
            int digit = n%10;
            arr.add(digit);
            n=n/10;
        }
        int max = 0;
        int len = arr.size();
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                int product = arr.get(i)*arr.get(j);
                if(max<product){
                    max = product;
                }
            }
        }
        return max;
        
    }
}