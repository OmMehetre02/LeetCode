// class Solution {
//     public int maximumLength(int[] a) {
//         Arrays.sort(a);
//         int ans=1;
//         for(int i=0;i<a.length;i++){
//             long cur = a[i];
//             int len=0;
//             while(true){
//                 int count = 0;
//                 for(int j=0;j<a.length;j++){
//                     if(a[j]==cur){
//                         count++;
//                     }
//                 }
//                 if(cur==1){
//                     if(count%2==0)len=count-1;
//                     else len=count;
//                     break;
//                 }
//                 if(count>=2){
//                     len+=2;
//                     cur=cur*cur;
//                 }else{
//                     if(count==1)len++;
//                     else len--;
//                     break;
//                 }
//             }
//             ans=Math.max(ans,len);
//         }
//         return ans;
//     }
// }



// class Solution {
//     public int maximumLength(int[] nums) {
//         Arrays.sort(nums);
//         int n = nums.length;
//         int ans = 1;

//         for (int i = 0; i < n; i++) {
//             long cur = nums[i];
//             int len = 0;

//             while (cur <= 1000000000L) {
//                 int cnt = count(nums, cur);

//                 if (cur == 1) {
//                     if (cnt % 2 == 0) len = cnt - 1;
//                     else len = cnt;
//                     break;
//                 }

//                 if (cnt >= 2) {
//                     len += 2;
//                     cur = cur * cur;
//                 } else {
//                     if (cnt == 1) len++;
//                     else len--;
//                     break;
//                 }
//             }

//             ans = Math.max(ans, len);
//         }

//         return ans;
//     }

//     public int count(int[] nums, long target) {
//         int c = 0;

//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] == target) {
//                 c++;
//             }
//         }

//         return c;
//     }
// }
import java.util.*;

class Solution {
    public int maximumLength(int[] nums) {

        HashMap<Long, Integer> map = new HashMap<>();

        // Count frequency
        for (int num : nums) {
            map.put((long) num, map.getOrDefault((long) num, 0) + 1);
        }

        int ans = 1;

        // Special case for 1
        if (map.containsKey(1L)) {
            int count = map.get(1L);
            if (count % 2 == 0)
                ans = Math.max(ans, count - 1);
            else
                ans = Math.max(ans, count);
        }

        // Check every starting number
        for (long x : map.keySet()) {

            if (x == 1) continue;

            long cur = x;
            int len = 0;

            while (map.getOrDefault(cur, 0) >= 2) {
                len += 2;
                cur = cur * cur;
            }

            if (map.getOrDefault(cur, 0) >= 1)
                len++;
            else
                len--;

            ans = Math.max(ans, len);
        }

        return ans;
    }
}