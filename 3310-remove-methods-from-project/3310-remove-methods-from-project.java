class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        List<List<Integer>> adjL = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjL.add(new ArrayList<>());
        }
        for(int[] edge : invocations){
            adjL.get(edge[0]).add(edge[1]);
        }

        boolean[] isSuspicious = new boolean[n];
        Deque <Integer> stack = new ArrayDeque<>();
        stack.push(k);
        isSuspicious[k] = true;
        while(!stack.isEmpty()){
            int currentMethod = stack.pop();
            for(int calledMethod : adjL.get(currentMethod)){
                if(!isSuspicious[calledMethod]){
                    isSuspicious[calledMethod] = true;
                    stack.push(calledMethod);
                }
            }
        }

        for(int[] edge:invocations){
            int caller = edge[0],called=edge[1];
            if(!isSuspicious[caller] && isSuspicious[called]){
                List all = new ArrayList<>();
                for(int m = 0; m<n; m++){
                    all.add(m);
                }
                return all;
            }
        }

        List result = new ArrayList<>();
        for(int m=0; m<n; m++){
            if(!isSuspicious[m]) result.add(m);
        }
        return result;
        
    }
}