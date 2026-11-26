class Solution {
    public boolean canAliceWin(int n) {
        boolean win = false;
        int i=10;
        while(n>0 && n>=i){
            n=n-i;
            
            if(i%2==0){
                i--;
                win = true;
            }
            else if(i%2!=0){
                i--;
                win = false;
            }
        }
        return win;
        
    }
}