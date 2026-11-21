class Solution {
    public String[] assignUmbrella(int[] rain) {
        int n = rain.length;
        String[] out = new String[n];
        int count =0;

        for(int i=0;i<n;i++){
            if(rain[i]==1){
                if(i+1<n && rain[i+1]==1 && count>=0){
                    out[i]="Alice";
                    count--;
                }
                else{
                    out[i]="Bob";
                    count++;
                }
            }
            else{
                out[i]="None";
            }
        }
        return out;
    }
}