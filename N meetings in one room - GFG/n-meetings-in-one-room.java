//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Pair implements Comparable<Pair>{
    int st;
    int et;
    Pair(int s,int e) {
        this.st=s;
        this.et=e;
    }
    public int compareTo(Pair other) {
        return this.et-other.et;
    }
}
class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        Pair pair[]=new Pair[n];
        for(int i=0;i<n;i++) {
            pair[i]=new Pair(start[i],end[i]);
        }
        Arrays.sort(pair);
        int count = 1;
        int end_time = pair[0].et;
        for(int i=1;i<n;i++) {
            if(pair[i].st > end_time) {
                count++;
                end_time = pair[i].et;
            }
        }
        return count;
    }
}

