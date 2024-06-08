package LinearDS.arrayProgram;
import java.util.*;
public class MultiDimensionArray {
	public static void main(String[] args) {
		int arr[][][][] = new int[3][2][3][3];
		int ind=0;
		
		for(int i =0;i<arr.length;i++) {
			for(int j =0;j<arr[i].length;j++) {
				for(int k=0;k<arr[i][j].length;k++) {
					for(int l=0;l<arr[i][j][k].length;l++) {
						System.out.println(arr[i][j][k][l]+" "+ind++);
					}
				}
			}
		}
	}
}