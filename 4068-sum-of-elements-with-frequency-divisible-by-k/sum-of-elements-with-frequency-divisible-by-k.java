class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
        int freq[]=new int [101];
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
        }
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(freq[nums[i]]%k==0){
                sum+=nums[i];
            }
        }
        return sum;
    }
}