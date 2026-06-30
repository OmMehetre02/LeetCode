class Solution {
    public int countPairs(int[] a, int k) {
        int count=0;
        for(int i=0;i<a.length-1;i++){
               int product=0;
               
            for(int j=i+1;j<a.length;j++){
                if(a[i]==a[j]){
                    product=i*j;
                    if(product%k==0){
                        count++;
                    }
                }

            }
        }
        return count;
    }
}