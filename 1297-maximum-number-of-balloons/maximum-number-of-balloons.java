class Solution {
    public int maxNumberOfBalloons(String text) {
        int a=0,b=0,l=0,o=0,n=0;
        for(int i=0;i<text.length();i++){
            char ch = text.charAt(i);
            if(ch=='b') b++;
            else if(ch=='a')a++;
            else if (ch=='l')l++;
            else if(ch=='o') o++;
            else if(ch=='n')n++;
        }
        return Math.min(
            Math.min(a,b),
            Math.min(Math.min(l/2,o/2),n)
        );
    }
}