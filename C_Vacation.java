package Atcoder_DP_Solutions;
import java.util.*;
public class C_Vacation {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long arr[][] = new long[n][3];
        long dp[][] = new long[n][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                arr[i][j] = sc.nextInt();
                dp[i][j] = -1l;
            }
        }
        long max = Long.MIN_VALUE;
        for(int j=0;j<3;j++){
            max = Math.max(max,findMax(arr,dp,0,j,j));
        }
        System.out.println(max);
    }
    public static long findMax(long arr[][],long dp[][],int i,int j,int s){
        if(i==dp.length-1)
            return arr[i][j];

        if(dp[i][j]!=-1)
            return dp[i][j];
        long a = 0l;
        for(int k = 0;k<3;k++){
            if(s!=k){
                a = Math.max(a,findMax(arr,dp,i+1,k,k));
            }
        }
        return dp[i][j] = arr[i][j] + a;
    }
}
