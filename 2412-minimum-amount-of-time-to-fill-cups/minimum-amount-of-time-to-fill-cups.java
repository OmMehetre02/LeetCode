class Solution {
    public int fillCups(int[] a) {
        Arrays.sort(a);
        int total=a[0]+a[1]+a[2];
        return Math.max(a[2],(total+1)/2);
    }
}