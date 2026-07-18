class Solution {
    public int maxProduct(int[] nums) {
    int large =0;
    int secondLarge=0;
    for(int i=0;i<nums.length;i++ ){
        if(nums[i]>large){
            secondLarge=large;
            large=nums[i];
        }else if(nums[i]>secondLarge){
            secondLarge=nums[i];
        }
    }
    return (large-1)*(secondLarge-1);
    }
}