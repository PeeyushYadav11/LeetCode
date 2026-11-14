class Solution {
    public List<String> generateParenthesis(int n) {
        //initilize an list for answer
        ArrayList<String> ans = new ArrayList<>();
        String curr = "";
        int open = 0;
        int close = 0;
        genrate(curr,open,close,n,ans);

        return ans;
        
    }

    public void genrate(String curr, int open, int close,int n, List<String> ans){
        //Base case
        if(open==n && close==n){
            ans.add(curr);
            return ;
        }

        if(open<n){
            genrate(curr+"(" , open+1 , close , n , ans);
        }

        if(close<open){
            genrate(curr+")" , open , close+1 , n , ans);
        }
    }
}