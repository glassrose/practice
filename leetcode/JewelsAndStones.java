package leetcode;

public class JewelsAndStones {

	public static void main(String[] args) {
		Solution s = new Solution ();
		
		System.out.println(s.numJewelsInStones("aA", "aAAbbbb"));

	}

}
class Solution {
    public int numJewelsInStones(String J, String S) {
        int jLen = J.length(), sLen = S.length();
        int jewelCount = 0;
        for(int i=0; i<jLen; i++) {
            int startIdx = -1;
            while (startIdx<sLen) {
//                if (startIdx==sLen-1 && J.charAt(i)==S.charAt(startIdx)) {
//                    jewelCount++;
//                    break;
//                }
                int nextJewelIdx = S.indexOf(J.charAt(i), startIdx+1);
                if (nextJewelIdx != -1)
                    jewelCount++;
                else
                	break;
                startIdx = nextJewelIdx;
            }
        }
        return jewelCount;
    }
}