class Solution {
    public int[] dailyTemperatures(int[] t) {
        int l = t.length;
        int[] ans = new int[l];

        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                if (t[j] > t[i]) {
                    ans[i] = j - i;
                    break;
                }
            }
        }
        return ans;
    }
}