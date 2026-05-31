class Solution {
    public int lengthOfLongestSubstring(String s) {
        int S=0,maxline=0;
        int []freq=new int[256];
        for(int E=0;E<s.length();E++){
            freq[s.charAt(E)]++;
            while(freq[s.charAt(E)]>1){
                freq[s.charAt(S)]--;
                S++;
            }
            maxline=Math.max(maxline,E-S+1);
        }
        
        return maxline;
    }
}