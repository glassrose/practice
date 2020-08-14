package leetcode;

public class FloodFill {

	public static void main(String[] args) {
		

	}

}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        ArrayList<ArrayList<Boolean>> visited = new ArrayList<ArrayList<Boolean>>();
        for (int i=0; i<image.length; i++){
            visited.add(new ArrayList<Boolean>(Collections.nCopies(image[0].length, new Boolean (false))));
        }
        floodFillRecur(image, visited, sr, sc, image[sr][sc], newColor);
        return image;
    }
    public void floodFillRecur(int[][] image, ArrayList<ArrayList<Boolean>> visited, int sr, int sc, int oldColor, int newColor) {
        if (!isValid(sr, sc, image) || image[sr][sc]!=oldColor || visited.get(sr).get(sc))
            return;
        
        image[sr][sc] = newColor;
        visited.get(sr).set(sc, true);
        
        floodFillRecur(image, visited, sr+1, sc, oldColor, newColor);
        floodFillRecur(image, visited, sr, sc+1, oldColor, newColor);
        floodFillRecur(image, visited, sr-1, sc, oldColor, newColor);
        floodFillRecur(image, visited, sr, sc-1, oldColor, newColor);
    }
    
    private boolean isValid(int r, int c, int[][] image) {
        
        return (0<=r && r<image.length && 0<=c && c<image.length);
        
    }
}
