package leetcode;

import java.util.ArrayList;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		Solution1 s = new Solution1();
		System.out.println(s.maxArea(new int[] {1,8,6,2,5,4,8,3,7}));

	}

}

class Solution1 {
    public int maxArea(int[] height) {
        ArrayList<Integer> highestRightmostIndexes = new ArrayList<> (height.length);
        for (int i=0; i<height.length-1; i++) {
            int maxRightIdx = i;
            for (int j=i+1; j<height.length; j++) {
                if (height[i]<=height[j])
                    maxRightIdx = j;
            }
            highestRightmostIndexes.add(maxRightIdx);
        }
        highestRightmostIndexes.add(0);
        
        ArrayList<Integer> highestLeftmostIndexes = new ArrayList<> (height.length);
        highestLeftmostIndexes.add(0);
        for (int i=1; i<height.length; i++) {
            int maxLeftIdx = i;
            for (int j=i-1; j>=0; j--) {
                if (height[i]<=height[j])
                    maxLeftIdx = j;
            }
            highestLeftmostIndexes.add(maxLeftIdx);
        }
        
        int resArea = 0;
        for(int i=0; i<height.length; i++) {
            resArea = Math.max(resArea, (Math.min(height[i], height[highestRightmostIndexes.get(i)])*Math.abs(i-highestRightmostIndexes.get(i))));
        }
        for(int i=0; i<height.length; i++) {
            resArea = Math.max(resArea, (Math.min(height[i], height[highestLeftmostIndexes.get(i)])*Math.abs(i-highestLeftmostIndexes.get(i))));
        }
        
        return resArea;
    }
}