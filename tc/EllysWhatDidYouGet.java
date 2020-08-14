package tc;

class EllysWhatDidYouGet {
	    
    int getCount(int N) {
        final int LIM = 50;
        int res = 0;
        for (int x=1; x<=LIM; x++) {
            for (int y=1; y<=LIM; y++) {
            	for(int z=1; z<=LIM; z++) {
                    boolean found = true;
                    int digSumForN1 = digSum(1*x*z + y*z);
                    for (int i=1; i<=N; i++) {
                        if (!(digSum(i*x*z + y*z) == digSumForN1)) {
                            found = false;
                            break;
                        }
                    }
                    if (found) {
                        res++;
                    }
                }
            }
        }
        
        return res;
    }
    
    private int digSum(int n) {
        int  sum = 0;
        while (n != 0) {
            sum += n% 10;
            n = n/10;
        }
        return sum;
    }
	    
	public static void main (String args[]) {
		EllysWhatDidYouGet o = new EllysWhatDidYouGet();
		System.out.println(o.getCount(9));
		System.out.println(o.getCount(5));
		System.out.println(o.getCount(13));
		System.out.println(o.getCount(42));
	}
	
}
