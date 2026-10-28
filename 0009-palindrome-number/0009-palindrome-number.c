bool isPalindrome(int x) {
    if (x < 0) return false;            // Bug 1 fix
    long long rev = 0;                  // Bug 2 fix
    int temp = x;
    while (temp != 0) {
        rev = rev * 10 + temp % 10;
        temp = temp / 10;
    }
    return rev == x;
}


