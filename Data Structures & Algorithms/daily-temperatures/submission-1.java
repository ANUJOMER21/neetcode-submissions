class Solution {
    public int[] dailyTemperatures(int[] t) {
          int l = t.length;
        int[] ans = new int[l];
        Stack<Integer> st = new Stack<>();   // stores INDICES
        for(int i =0;i<l;i++){
            while(!st.isEmpty() && t[i]>t[st.peek()]){
                int j=st.pop();
                ans[j]=i-j;
            }
            st.push(i);
        }
        return ans;
    }
    
}
