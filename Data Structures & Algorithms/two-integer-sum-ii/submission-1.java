class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int p1=0;
        int p2=1;
      int ans[] = new int[2];
      boolean get_ans=false;
    for(int i=0;i<numbers.length-1;i++)
        {
            for(int j=i+1;j<numbers.length;j++){
                if(numbers[i]+numbers[j]==target)
                {
                    ans[0]=i+1;
                    ans[1]=j+1;
                    get_ans=true;

                }
                if(get_ans) break;
            }
            if(get_ans) break;
        }
    return ans;
    }
}
