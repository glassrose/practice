package interviews;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class BookSale {
    public static int nthLowestSelling(int[] sales, int n) {
        
    	HashMap<Integer, Integer> freq = new HashMap()<>();
    	
    	for(int i=0; i<sales.length; i++) {
    		freq.put(i, sales[i]);
    	}
    	
    	Set<Map.Entry<Integer, Integer>> entries = freq.entrySet();
    	PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>();
    	
    	for(Map.Entry<Integer, Integer> entry: entries.)
    	
    }

    public static void main(String[] args) {
        int x = nthLowestSelling(new int[] { 5, 4, 3, 2, 1, 5, 4, 3, 2, 5, 4, 3, 5, 4, 5 }, 2);
        System.out.println(x);
    }
}