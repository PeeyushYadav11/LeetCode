class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int mid = n/2;

        List <Character> list = new ArrayList<>();
        int i=0;
        while(i<mid){
            list.add(s.charAt(i));
            i++;
        }
        Collections.sort(list);
        if(n%2!=0){
            list.add(s.charAt(mid));
            
        }
        i=mid-1;
        while(i>=0){
            list.add(list.get(i));
            i--;

        }
        StringBuilder sb = new StringBuilder();

        for(char c : list){
            sb.append(c);
        }

        return sb.toString();
    }
}