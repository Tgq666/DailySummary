package com.todd;

/**
 * 重要*****
 * 给你一根长度为n的绳子，请把绳子剪成整数长度的m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 思路: dp[i]表示到i位置绳子切割后乘积的最大值
 * 注意dp[i]表示i长的绳子至少切一次
 * 注意(i-j)与dp[i-j]的区别 i-j之前的绳子一次没切 dp[i-j]表示切了至少一次 两者也应比较
 * dp[i]=max(dp[i],dp[i-j]*j,(i-j)*j)
 *
 *
 * @Author todd
 * @Date 2020/5/15
 */
public class Offer14_1 {
    public int cuttingRope(int n) {
        if(n == 2){
            return 1;
        }
        int[] dp = new int[n + 1];
        for(int i = 3; i <= n; i++){
            for(int j = 1; j < i; j++){
                dp[i] = Math.max(dp[i], Math.max(dp[i - j] * j, (i - j) * j));
            }
        }
        return dp[n];
    }
}
