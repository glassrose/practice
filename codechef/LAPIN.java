

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt (br.readLine());
		//int[] alphabet;
		final int nCharSet = 26;
		for (int t=0; t<T; t++) {
		    int[] alphabet = new int[nCharSet];
		    Arrays.fill(alphabet, 0);
		    
		    String word = br.readLine();
		    int len = word.length();
		    
		    for (int i=0; i<len/2; i++) {
		        alphabet[word.charAt(i)-'a']++; 
		    }
		    System.out.println(Arrays.toString(alphabet));
		   
		    for (int i=len-1; i>=(len+1)/2; i--) {
		        alphabet[word.charAt(i)-'a']--;
		    }
		    System.out.println(Arrays.toString(alphabet));
		   
		    boolean isLapin = true;
		    for (int i=0; i<nCharSet; i++) {
		        if (alphabet[i] != 0)
		            isLapin = false;
		            break;
		    }
		    if (!isLapin)
		        System.out.println("NO");
		    else
    		    System.out.println("YES");
		    
		}
		
	}
}

