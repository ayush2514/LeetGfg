//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int search(String pat, String txt) {
        Map<Character,Integer> pmap=new HashMap<>();
        for(char ch:pat.toCharArray())
            pmap.put(ch,pmap.getOrDefault(ch,0)+1);
        int i=0, j=0, count=pmap.size(), ans=0;
        while(j<txt.length()) {
            char c1=txt.charAt(j);
            if(pmap.containsKey(c1)) {
                pmap.put(c1,pmap.get(c1)-1);
                if(pmap.get(c1)==0) count--;
            }
            if(j-i+1<pat.length()) j++;
            else if(j-i+1==pat.length()) {
                if(count==0) ans++;
                char c2=txt.charAt(i);
                if(pmap.containsKey(c2)) {
                    pmap.put(c2,pmap.get(c2)+1);
                    if(pmap.get(c2)==1) count++;
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}
