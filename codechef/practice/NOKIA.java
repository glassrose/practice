package practice;
/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		int T = Integer.parseInt (br.readLine());
		for(int t=0; t<T; t++) {
		    String[] lineWords = (br.readLine()).split(" ");
		    int N = Integer.parseInt(lineWords[0]);
		    int M = Integer.parseInt(lineWords[1]);
		    
		    Codechef c = new Codechef();
		    
		    int minUnusedWire = M;
		    for (int i=0; i<N; i++) {
		    	minUnusedWire = Math.min(minUnusedWire, c.getMinUnusedWire(0, i, N, M));
		    }
		    System.out.println();
		}
	}
	
	
	private int getMinUnusedWire(int start, int pos, int n, int unusedWire) {
	    if (unusedWire <= 0) {
	        return -1; //insufficient wire
	    }
	    return Math.min(getMinUnusedWire(0, pos, n, ), b);
	}
}
