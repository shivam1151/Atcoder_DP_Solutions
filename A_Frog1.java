package Atcoder_DP_Solutions;
import java.util.*;
public class A_Frog1 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        int dp[] = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
            dp[i] = -1;
        }
        System.out.println(findMin(arr,dp,0));
    }

    public static int findMin(int arr[],int dp[],int idx) {
        if(idx==arr.length-1)
            return 0;
        if(idx>=arr.length)
            return Integer.MAX_VALUE;
        if(dp[idx]!=-1)
            return dp[idx];

        int a = findMin(arr,dp,idx+1);
        if(a!=Integer.MAX_VALUE) {
            a+= Math.abs(arr[idx]-arr[idx+1]);
        }
        int b = findMin(arr,dp,idx+2);
        if(b!=Integer.MAX_VALUE) {
            b+= Math.abs(arr[idx]-arr[idx+2]);
        }

        return dp[idx] = Math.min(a, b);
    }

}

