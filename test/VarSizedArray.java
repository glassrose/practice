import java.util.Arrays;

public class VarSizedArray {
	public static void main(String args[]) {
		for (int i=0; i<5; i++) {
			int[] arr = createMyArray(i);
			printArr(arr);
		}
	}

	private static void printArr(int[] arr) {
		System.out.println(Arrays.toString(arr));
		
	}

	private static int[] createMyArray(int i) {
		int[] arr = new int[i];
		Arrays.fill(arr, i);
		return arr;
	}
}
