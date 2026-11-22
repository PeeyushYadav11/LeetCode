class Solution {
    public boolean checkString(String s) {
        boolean flag =true;
        int n = s.length();
        for(int i=0; i<n; i++){
            if(i+1<n && s.charAt(i)=='b' && s.charAt(i+1)=='a'){
                flag = false;
            }
        }
        return flag;
        
    }
}