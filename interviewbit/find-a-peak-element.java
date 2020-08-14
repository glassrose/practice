public class Solution {
    public int solve(ArrayList<Integer> A) {
        
        int n = A.size();
        int min = 0, max = n-1;
        
        solve_helper(A, int min, int max);
    }
    
    solve_helper (ArrayList<Integer> A, int min, int max) {
        while (min<=max) {
            int mid = min + (max-min)/2;
            if (isPeak(A, mid))
                return true;
            else
                System.out.println ("DEBUG: No Peak found");
                
            solve_helper(A, min, mid-1);
            solve_helper(A, mid+1, max);
        }
    }
}

