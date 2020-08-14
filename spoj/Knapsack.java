package spoj;

import java.util.*;
import java.lang.*;
 
//AC! :)
class Knapsack
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner (System.in);
		int s = sc.nextInt();
		int n = sc.nextInt();
		
		int[] size = new int[n+1];
		long[] val = new long[n+1];
		for (int i=1; i<=n; i++) {
			size[i] = sc.nextInt();
			val[i] = sc.nextInt();
		}
		sc.close();
		
		long[][] memo = new long[n+1][s+1];
		for (int i=0; i<=n; i++) {
			for (int j=0; j<=s; j++) {
//				if (i==0 || j==0)
//					memo[i][j] = 0;
				memo[i][j] = -1;
			}
		}
		System.out.println(getMaxVal(size, val, s, n, memo));
	}

	private static long getMaxVal(int[] size, long[] val, int s, int n, long[][] memo) {
		if (n<=0 || s<=0)
			return 0;

		if (memo[n][s] != -1)
			return memo[n][s];

		memo[n][s] = Math.max (
			val[n] + getMaxVal(size, val, s-size[n], n-1, memo),
			getMaxVal(size, val, s, n-1, memo)
			);

		return memo[n][s];
	}
} 