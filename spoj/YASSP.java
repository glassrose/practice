package spoj;

import java.util.HashSet;
import java.util.Scanner;

//class Cell {
////	public Set<Set<Integer>> subsets;
//	public Set<Integer> uniqueSubsetSizes;
//	Cell() {
////		subsets = new HashSet<>();
//		uniqueSubsetSizes = new HashSet<>();
//	}
//}

public class YASSP {
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int T = sc.nextInt();
		while(T-- != 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			int arrSum = 0;
			for (int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
				arrSum += arr[i];
			}
			
			HashSet<Integer>[] subsetSumCounts = getUniqueSubsetSizesForSubsetSum(arr, arrSum);
			
			int maxCount = 0;
			int maxSubsetCountWeight = -1;
			for (int i=0; i<subsetSumCounts.length; i++) {
				if (maxCount < subsetSumCounts[i].size()) {
					maxCount = subsetSumCounts[i].size();
					maxSubsetCountWeight = i;
				}
			}
			
			System.out.println(maxCount + " " + maxSubsetCountWeight);
		}

		sc.close();
	}

//	private static int[] getCountsOfSubsetSum(int[] arr, int arrSum) {
//		int [][] dp = new int[arr.length+1][arrSum+1];
//		
//		for (int i=0; i<dp.length; i++) {
//			dp[i][0] = 1;
//		}
//		for (int j=1; j<dp[0].length; j++) {
//			dp[0][j] = 0;
//		}
//		for (int i=1; i<dp.length; i++) {
//			for(int j=1; j<dp[0].length; j++) {
//				if(arr[i-1] <= j) {
//					dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
//				}
//				else {
//					dp[i][j] = dp[i-1][j];
//				}
//			}
//		}
//		return dp[dp.length-1];
//	}
	
	private static HashSet<Integer>[] getUniqueSubsetSizesForSubsetSum (int[] arr, int arrSum) {
		HashSet<Integer>[][] dp = new HashSet[arr.length+1][arrSum+1];
		
		for (int i=0; i<dp.length; i++) {
			dp[i][0] = new HashSet<>();
//			dp[i][0].subsets.add(new HashSet<>());
			dp[i][0].add(0);
		}
		for (int j=1; j<dp[0].length; j++) {
			dp[0][j] = new HashSet<>();
		}
		
		for (int i=1; i<dp.length; i++) {
			for(int j=1; j<dp[0].length; j++) {
				dp[i][j] = new HashSet<>();
				if(arr[i-1] <= j) {
					for (Integer subsetSize: dp[i-1][j-arr[i-1]]) {
						dp[i][j].add(subsetSize+1);
					}
					dp[i][j].addAll(dp[i-1][j]);
				} else {
					dp[i][j].addAll(dp[i-1][j]);
				}
			}
		}
		
		return dp[dp.length-1];
		
	}
}
