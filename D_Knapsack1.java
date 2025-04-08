package Atcoder_DP_Solutions;
import java.util.*;
public class D_Knapsack1 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();
        int w =  sc.nextInt();
        int val[] = new int[n];
        int wt[] = new int[n];
        long dp[][] = new long[n][w+1];
        for(long i[]:dp)
            Arrays.fill(i,-1l);
        for(int i=0;i<n;i++){
            wt[i] = sc.nextInt();
            val[i] = sc.nextInt();
        }
        long ans = findMax(n,w,val,wt,dp,0);
        System.out.println(ans);
    }

    public static long findMax(int n,int w,int val[],int wt[],long dp[][],int i){
        if(w==0 || i>=val.length)
            return 0;

        if(dp[i][w]!=-1)
            return dp[i][w];
        long pick = 0;
        if(w-wt[i]>=0)
        pick = val[i] + findMax(n,w-wt[i],val,wt,dp,i+1);
        long notPick = findMax(n,w,val,wt,dp,i+1);

        return dp[i][w] = Math.max(pick,notPick);
    }
}
