package Recursion.backtracking;

import java.util.*;

public class Chess {
	public boolean isValid(boolean arr[][],int r,int c) {
		return r>=0&&r<arr.length&&c>=0&&c<arr[0].length;
	}
	public ArrayList<boolean[][]> placeNQueen(int n) {
		 return placeNQueen(new boolean[n][n],0);
	}
	private ArrayList<boolean[][]> placeNQueen(boolean board[][],int row) {
		ArrayList<boolean[][]>res = new ArrayList<boolean[][]>();
		if(row==board.length) {
			boolean[][] newBoard = new boolean[board.length][board.length];
	        for (int i = 0; i < board.length; i++) {
	            newBoard[i] = Arrays.copyOf(board[i], board[i].length);
	        }
			res.add(newBoard);
			for(boolean arr[] : newBoard) {
				for(int i=0;i<arr.length;i++) {
					System.out.print(arr[i]+" ");
				}
				System.out.println();
			}
			System.out.println();
			return res;
		}
		for(int i=0;i<board[row].length;i++) {
			if(isSafe(row,i,board,"queen")) {
				board[row][i] = true;
				res.addAll(placeNQueen(board,row+1));
				board[row][i] = false;
			}
		}
		return res;
	}
	//N-Knights Placing 
	public ArrayList<boolean[][]> NKnights(int n) {
		return NKnights(new boolean[n][n], 0, 0,n);
	}
	private ArrayList<boolean[][]> NKnights(boolean board[][],int r,int c,int knights){
		ArrayList<boolean[][]>res = new ArrayList<>();
		if(knights==0) {
			boolean newFormed[][] = new boolean[board.length][board[0].length];
			for(int i=0;i<board.length;i++) {
				newFormed[i] = Arrays.copyOf(board[i], board[i].length);
			}
			res.add(newFormed);
			return res;
		}
		if(r>=board.length) {
			return res;
		}
		if(c>=board[0].length) {
			res.addAll(NKnights(board, r+1, 0, knights));
			return res;
		}
		if(isValid(board,r,c)&&isSafe(r,c,board,"knight")) {
			board[r][c] = true;
			res.addAll(NKnights(board, r, c+1, knights-1));
			board[r][c] = false;
		}
		res.addAll(NKnights(board,r,c+1,knights));
		return res;
	}
	private boolean isSafe(int row, int col, boolean[][] board,String type) {
	        if(type.equals("queen")) {
				// Check the column
		        for (int i = 0; i < row; i++) {
		            if (board[i][col]) {
		                return false;
		            }
		        }
		        // Check the upper left diagonal
		        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
		            if (board[i][j]) {
		                return false;
		            }
		        }
		        // Check the upper right diagonal
		        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
		            if (board[i][j]) {
		                return false;
		            }
		        }
		        return true;
	        }
	        else if(type.equals("knight")) {
	        	boolean found1=false,found2=false,found3=false,found4 = false;
	        	if(row>1&&col>0) {
	        		found1 = board[row-2][col-1];
	        	}
	        	else if(row>0&&col>1) {
	        		found2 = board[row-1][col-2];
	        	}
	        	else if(row>1&&col<board[row].length-1) {
	        		found3 = board[row-2][col+1];
	        	}
	        	else if(row>0&&col<board[row].length-2) {
	        		found4 = board[row][col+2];
	        	}
	        	return !(found1||found2||found3||found4);
	        }
	        return false;
    }
	public static void main(String args[]) {
		Chess chess = new Chess();
		ArrayList<boolean[][]>knightBoard = chess.NKnights(3);
		for(boolean[][] arr : knightBoard) {
			for(boolean[] row : arr) {
				for(int i =0;i<row.length;i++) {
					System.out.print(row[i]+" ");
				}
				System.out.println();
			}
			System.out.println("______________________");
		}
	}

}
