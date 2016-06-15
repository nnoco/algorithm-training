
/**
 * 쿠팡 전화인터뷰 매트릭스 순회 문제
 * @author nnoco
 *
 */
public class MatrixTraversing {
	public void zigzag(int[][] matrix) {
		int length = matrix[0].length * matrix.length;
		
		int direction = +1; // to right
		int row = 0, col = 0;
		for(int count=0 ; count < length ; count++) {
			System.out.println(matrix[row][col]);
			
			col += direction;
			
			if(col == matrix[row].length) {
				row++;
				col = matrix[row].length - 1;
				direction *= -1;
			} else if (col == -1) {
				row++;
				col = 0;
				direction *= -1;
			}
		}
	}
	
	public void zigzagDiagonal(int[][] matrix) {
		int rowMax = matrix.length;
		int colMax = matrix[0].length;
		
		int length = matrix[0].length * matrix.length;
		
		int direction = 1;
		int row = 0, col = 0;
		boolean toggle = false;
		for(int count = 0; count < length ; count++, toggle=false) {
			System.out.println(count + ": " + matrix[row][col]);
			
			row -= direction;
			col += direction;
			
			if(row == -1 && col != colMax) {
				row = 0;
				toggle = true;
			}
			if(col == -1 && row != rowMax) {
				col = 0;
				toggle = true;
			}
			if(row == rowMax) {
				row--;
				col += 2;
				toggle = true;
			}
			if(col == colMax) {
				col--;
				row += 2;
				toggle = true;
			}
			
			if(toggle) {
				direction *= -1;
			}
			
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = {
				{1, 2, 3, 4, 5, 6},
				{7, 8, 9, 10, 11, 12},
				{13, 14, 15, 16, 17, 18},
				{19, 20, 21, 22, 23, 24}
		};
		
		System.out.println(matrix.length + ", " + matrix[0].length);
		new MatrixTraversing().zigzagDiagonal(matrix); // zigzag(matrix);
	}
}
