package Atcoder_DP_Solutions;
import java.util.*;
//Change class name to Main to submit on atcoder
public class B_Frog2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        int dp[] = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        dp[arr.length-1] = 0;
        dp[arr.length-2] = Math.abs(arr[arr.length-1]-arr[arr.length-2]);
        for(int i=arr.length-3;i>=0;i--) {
            int cost = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if ((i + j) >= arr.length)
                    break;
                cost = Math.min(cost, Math.abs(arr[i] - arr[i + j]) + dp[i + j]);
            }
            dp[i] = cost;
        }
        System.out.println(dp[0]);
    }
}