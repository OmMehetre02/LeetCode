class Solution {
    public void sortColors(int[] a) {
      int left=0;
      int right=a.length-1;
      int i=0;
      while(i<=right){
        if(a[i]==0){
            int temp=a[i];
            a[i]=a[left];
            a[left]=temp;
            left++;
            i++;
        }else if(a[i]==2){
            int temp=a[i];
            a[i]=a[right];
            a[right]=temp;
            right--;
        }else{
            i++;
        }
      }
    }
}