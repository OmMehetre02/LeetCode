class Solution {
    public String kthDistinct(String[] a, int k) {
        int distinctCount=0;
        for(int i=0;i<a.length;i++){
            int count=0;
            for(int j=0;j<a.length;j++){
                if(a[i].equals(a[j]) ){
                    count++;
                }
            }
            if(count==1){
                distinctCount++;
                if(distinctCount==k){
                   return  a[i];
                }
            }
        }
        return "";
    }
}