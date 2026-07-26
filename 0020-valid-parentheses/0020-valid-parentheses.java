class Solution {
    public boolean isValid(String s) {
        int top = 0;
        int n = s.length();
        char[] arr = new char[n];

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                arr[top++] = ch;
            } 
            else {
                if (top == 0) return false;

                if ((arr[top - 1] == '(' && ch == ')') ||
                    (arr[top - 1] == '{' && ch == '}') ||
                    (arr[top - 1] == '[' && ch == ']')) {
                    top--;
                } else {
                    return false;
                }
            }
        }

        return top == 0;
    }
}
