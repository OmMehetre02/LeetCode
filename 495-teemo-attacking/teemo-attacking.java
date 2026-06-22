class Solution {
    public int findPoisonedDuration(int[] t, int d) {
      int total=0;
      for(int i=0;i<t.length-1;i++){
        int gap = t[i+1]-t[i];
        if(gap>=d){
            total+=d;
        }
        else{
            total+=gap;
        }
      }
      total+=d;
      return total;
    }
}