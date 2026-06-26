class Solution {
    public int distinctIntegers(int n) {
        int count=0;
        if(n<=2)return 1;
        for(int i=1;i<n;i++){
            if(n%(n-1)==1){
                count++;
            }
        }
        return count;
    }
}