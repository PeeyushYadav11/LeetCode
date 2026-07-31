import java.util.*;

class Solution {
    public int minimumPushes(String word) {

        int[] freq = new int[26];

        
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            freq[index] = freq[index] + 1;
        }

        
        Arrays.sort(freq);

        int pushes = 0;
        int position = 0;

        
        for (int i = 25; i >= 0; i--) {

            if (freq[i] == 0)
                break;

            int cost = (position / 8) + 1;
            pushes = pushes + freq[i] * cost;
            position++;
        }

        return pushes;
    }
}