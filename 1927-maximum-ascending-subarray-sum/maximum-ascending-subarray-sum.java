class Solution {
    public int maxAscendingSum(int[] a) {
        int sum=a[0];
        int max=a[0];
        for(int i=1;i<a.length;i++){
            if(a[i]>a[i-1]){
                sum+=a[i];
            }else{
                sum=a[i];
            }
            if(sum>max){
                max=sum;
            }
        }
        return max;
    }
}