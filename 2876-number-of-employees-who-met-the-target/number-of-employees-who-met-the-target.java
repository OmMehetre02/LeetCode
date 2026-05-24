class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] h, int target) {
        int count=0;
        for(int i=0;i<h.length;i++){
            if(h[i]>=target){
                count++;
            }
        }
        return count;
    }
}