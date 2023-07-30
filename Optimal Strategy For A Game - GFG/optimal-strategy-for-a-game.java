//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class OptimalStrategy
{
    public static void main (String[] args) {
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total number of testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //taking number of elements
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            //inserting the elements
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
                
           //calling the countMaximum() method of class solve
           System.out.println(new solve().countMaximum(arr, n)); 
        }
    }
    
    
}
// } Driver Code Ends



class solve
{
    //Function to find the maximum possible amount of money we can win.
    static long countMaximum(int arr[], int n)
    {
        // Your code here
        int dp[][]=new int[n][n];
        for(int gap=0;gap<n;gap++) {
            for(int i=0,j=gap;j<n;j++,i++) {
                if(gap==0)
                dp[i][j]=arr[i];
                else if(gap==1)
                dp[i][j]=Math.max(arr[i],arr[j]);
                else {
                    int val1=arr[i]+Math.min(dp[i+2][j],dp[i+1][j-1]);
                    int val2=arr[j]+Math.min(dp[i+1][j-1],dp[i][j-2]);
                    int val=Math.max(val1,val2);
                    dp[i][j]=val;
                }
            }
        }
        return dp[0][n-1];
    }
}
