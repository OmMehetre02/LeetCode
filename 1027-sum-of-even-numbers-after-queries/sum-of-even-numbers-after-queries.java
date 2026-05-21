class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] q) {
        int evensum=0;
      for(int i=0;i<nums.length;i++){
           if(nums[i]%2==0){
            evensum+=nums[i];
           }
      }
      int ans[]=new int[q.length];
      for(int i=0;i<q.length;i++){
        int val=q[i][0];
        int index=q[i][1];
        if(nums[index]%2==0){
            evensum=evensum-nums[index];
        }
        nums[index]=nums[index]+val;
        if(nums[index]%2==0){
            evensum=evensum+nums[index];
        }
        ans[i]=evensum;
      }
      return ans;
    }
}