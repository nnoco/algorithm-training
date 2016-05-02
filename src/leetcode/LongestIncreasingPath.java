package leetcode;

import java.util.Arrays;

/**
	329. Longest Increasing Path in a Matrix - https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
	
	Given an integer matrix, find the length of the longest increasing path.

	From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
	
	Example 1:
	
	nums = [
	  [9,9,4],
	  [6,6,8],
	  [2,1,1]
	]
	Return 4
	The longest increasing path is [1, 2, 6, 9].
	
	Example 2:
	
	nums = [
	  [3,4,5],
	  [3,2,6],
	  [2,2,1]
	]
	Return 4
	The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 * @author nnoco
 *
 */
public class LongestIncreasingPath {
	public int longestIncreasingPath(int[][] matrix) {
		if(matrix.length == 0 || matrix[0].length == 0) return 0;
		
		Cell[][] cellMatrix = new Cell[matrix.length][matrix[0].length];
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				cellMatrix[i][j] = new Cell(cellMatrix, matrix[i][j], i, j);
			}
		}
		
		link(cellMatrix);
		
		return findPath(cellMatrix);
    }
	
	void printChecked(Cell[][] cellMatrix) {
		for(Cell[] rows : cellMatrix) {
			for(Cell cell : rows) {
				System.out.print(cell.length + "\t");
			}
			
			System.out.println();
		}
	}
	
	void printCells(Cell[][] cellMatrix) {
		for(Cell[] rows : cellMatrix) {
			for (Cell cell : rows) {
				System.out.printf("\t   %s\t\t", cell.up != null ? "^" : "");
			}
			System.out.println();
			for(Cell cell : rows) {
				System.out.printf("\t%s %d %s\t\t",
						cell.left != null ? "<" : " ",
						cell.value,
						cell.right != null ? ">" : " ");
			}
			
			System.out.println();
			
			for (Cell cell : rows) {
				System.out.printf("\t   %s\t\t", cell.down != null ? "V" : "");
			}
			
			System.out.println();
			System.out.println();
		}
	}

	void link(Cell[][] cellMatrix) {
		retrive(cellMatrix, cell -> {cell.init();});
	}
	
	int findPath(Cell[][] cellMatrix) {
		int max = 0;
		for(Cell[] rows : cellMatrix) {
			for(Cell cell : rows) {
				int result = findPath(cell, 1);
				
				max = result > max ? result : max;
			}
		}
		
		return max;
	}
	
	int findPath(Cell cell, int length) {
		if(null == cell) return 0;
		if(cell.checked) return cell.length;
		
		int left = findPath(cell.left, length+1);
		int right = findPath(cell.right, length+1);
		int up = findPath(cell.up, length+1);
		int down = findPath(cell.down, length+1);
		
		int max = Math.max(Math.max(left, right), Math.max(up, down));
		
		cell.length = max + 1;
		cell.checked = true;
		
		return cell.length;
	}
	
	void retrieve(Cell cell) {
		if(cell == null) return;
		
		System.out.println(cell);
		
		retrieve(cell.left);
		retrieve(cell.right);
		retrieve(cell.up);
		retrieve(cell.down);
	}
	
	
	void printChecked(int[][] checked) {
		for(int[] rows : checked) {
			System.out.println(Arrays.toString(rows));
		}
	}
	
	void retrive(Cell[][] cellMatrix, CellBehavior behavior) {
		for(Cell[] rows : cellMatrix) {
			for(Cell cell : rows) {
				behavior.behave(cell);
			}
		}
	}
	
	@FunctionalInterface
	static interface CellBehavior {
		void behave(Cell cell);
	}
	
	static class Cell {
		final int value, row, col;
		Cell[][] matrix;
		Cell left, right, up, down;
		
		boolean checked;
		int length;
		
		public Cell(Cell[][] matrix, int value, int row, int col) {
			this.matrix = matrix;
			this.value = value;
			this.row = row;
			this.col = col;
			
		}
		
		private void init() {
			// left x, y-1
			if(col > 0 && matrix[row][col-1].value < value) {
				left = matrix[row][col-1];
			}
			
			// right
			if((col < matrix[0].length - 1) && matrix[row][col+1].value < value) {
				right = matrix[row][col+1];
			}
			
			// up
			if(row > 0 && matrix[row-1][col].value < value) {
				up = matrix[row-1][col];
			}
			
			// down
			if(row < matrix.length-1 && matrix[row+1][col].value < value) {
				down = matrix[row+1][col];
			}
			
		}

		@Override
		public String toString() {
			return "Cell [value=" + value + ", row=" + row + ", col=" + col
					+ "]" + (left != null ? "< " : "X ") +
					(right != null ? "> " : "X ") +
					(up != null ? "A " : "X ") +
					(down != null ? "V " : "X ");
		}
		
		
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{0,1,2,3,4,5,6,7,8,9},{19,18,17,16,15,14,13,12,11,10},{20,21,22,23,24,25,26,27,28,29},{39,38,37,36,35,34,33,32,31,30},{40,41,42,43,44,45,46,47,48,49},{59,58,57,56,55,54,53,52,51,50},{60,61,62,63,64,65,66,67,68,69},{79,78,77,76,75,74,73,72,71,70},{80,81,82,83,84,85,86,87,88,89},{99,98,97,96,95,94,93,92,91,90},{100,101,102,103,104,105,106,107,108,109},{119,118,117,116,115,114,113,112,111,110},{120,121,122,123,124,125,126,127,128,129},{139,138,137,136,135,134,133,132,131,130},{0,0,0,0,0,0,0,0,0,0}};
		
		int result = new LongestIncreasingPath().longestIncreasingPath(matrix);
		
		System.out.println(result);
	}
}
