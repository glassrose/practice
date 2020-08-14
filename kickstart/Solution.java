package kickstart;


import java.io.BufferedReader;
import java.util.Scanner;

public class Solution {
    public static void main (String args[]) {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    	
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t=1; t<=T; t++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            
            int res = 0;
            for (int i=0; i<N; i++) {
                int n = N; 
                int k = K;
                while ((n--) != 0) {
                    int num = sc.nextInt();
                    if (num == k) {
                        k--;
                        if (k==0) {
                            res++;
                        }
                    }
                    else {
                        k = K;
                    }
                }
                
            }
            System.out.println("Case #"+t+": "+res);
        }
        sc.close();
        
    }
}