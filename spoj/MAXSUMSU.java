package spoj;

import java.util.Scanner;

public class MAXSUMSU {
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int T = sc.nextInt();
		while(T-- != 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			
			int max_so_far = 0;
			int max_till_here = 0;
			for (int i=0; i<n; i++) {
				max_till_here = max_till_here + arr[i];
				max_so_far = Math.max(max_so_far, max_till_here);
				max_till_here = Math.max(max_till_here, 0);
			}
			
			System.out.println(max_so_far);
		}

		sc.close();
		
	}
}
