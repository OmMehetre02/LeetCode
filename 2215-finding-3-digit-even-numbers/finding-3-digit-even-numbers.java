class Solution {
    public int[] findEvenNumbers(int[] d) {
        HashSet<Integer> set = new HashSet<>();
        int n=d.length;
        for(int i=0;i<n;i++){
            if(d[i]==0){
                continue;
            }
            for(int j=0;j<n;j++){
                if(j==i){
                    continue;
                }
                for(int k=0;k<n;k++){
                    if(k==j||k==i){
                        continue;
                    }
                    if(d[k]%2!=0){
                        continue;
                    }
                    int num=d[i]*100+d[j]*10+d[k];
                    set.add(num);
                }
            }
        }
        int ans[]=new int [set.size()];
        
        Integer[] temp = set.toArray(new Integer[0]);

        for (int i = 0; i < temp.length; i++) {
            ans[i] = temp[i];
        }
        Arrays.sort(ans);

        return ans;
    }
}