class Solution {
    public int minimumPushes(String word) {
        int ans = 0; 
        int i=0;
        int div = word.length()/8;
        ans = ans + ((word.length()%8)*(div+1));
        ans = ans + (4*(div*(div+1)));
        return ans;
    }
}