/*
 * A N x M (N mean number of rows, M means number of columns) matrix represented with 0 and 1, 0 means path, 1 mean blocked
 * start point A at left-up corner, end point B at bottom-right corner
 * the movement is only to right, or to down 
 * find how many ways of path from A to B 
 */
public class FindPathsFromAToB {

	static int recursiveSolution(int[][] matrix, int row, int col) {
		if (row == matrix.length) {
			return 0;
		}
		if (col == matrix[0].length) {
			return 0;
		}
		if (matrix[row][col] == 1) {
			return 0;
		}
		if (row == matrix.length - 1 && col == matrix[0].length - 1) {
			return 1;
		}
		return recursiveSolution(matrix, row + 1, col) + recursiveSolution(matrix, row, col + 1);
	}

	static int DP(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) 
			return 0;
		
		int row = matrix.length;
		int col = matrix[0].length;
		int[][] paths = new int[row][col];
				
		for (int i = row - 1; i >= 0; i--) {
			for (int j = col - 1; j >= 0; j--) {
				if (i == row - 1 || j == col - 1) {
					paths[i][j] = 1;
				}
				else {
					paths[i][j] = (matrix[i][j] == 0 ? paths[i + 1][j] + paths[i][j + 1] : 0);	
				}
			}
		}
				
		return paths[0][0];
	}

	public static void main(String[] args) {
		int[][] matrix = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
		
		System.out.println("recursive solution: " + recursiveSolution(matrix, 0, 0));
		System.out.println("DP solution:" + DP(matrix));
	}

}
