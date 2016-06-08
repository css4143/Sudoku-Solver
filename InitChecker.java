
/**
 * This class will be used to check a board's initial state to try and see if
 * it is unsolvable.  This was made to deal with long run times when the solver
 * is faced with a sparse, unsolvable graph.
 * 
 * @author Connor Seiden
 * @version 6-7-2016
 */
public class InitChecker {
	
	/**
	 * Check if an initial board state is invalid or not.  Returns false if this
	 * method detects that the board is unsolvable, and true otherwise.
	 * 
	 * @param b		The initial board
	 * @return		False if the board is unsolvable, true otherwise
	 */
	public static boolean check(Board b){
		if(spaceCheck(b) && checkDups(b) && checkRows(b) && checkCols(b) && checkSqrs(b)){
			return true;
		}
		return false;
	}
	
	/**
	 * Find the valid numbers for each empty space, if any have no valid
	 * numbers then the board is unsolvable.
	 * 
	 * @param b		The initial board
	 * @return		False if the board is unsolvable, true otherwise
	 */
	public static boolean spaceCheck(Board b){
		for(int x=0;x<9;x++){
			for(int y=0;y<9;y++){
				if(b.get(x, y) == 0){
					if(b.getValids(x, y) == null){
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	/**
	 * For every space that has a number in it, see if there are any duplicates
	 * of this number in the same row, column, or square.
	 * 
	 * @param b		The initial board
	 * @return		False if the board is unsolvable, true otherwise
	 */
	public static boolean checkDups(Board b){
		for(int x=0;x<9;x++){
			for(int y=0;y<9;y++){
				if(b.get(x, y) != 0){
					int c = b.get(x, y);
					
					//check the column for duplicates
					int[] temp = b.getCol(x);
					for(int i=0;i<temp.length;i++){
						if(c == temp[i] && y != i){ return false; }
					}
					
					//check the row for duplicates
					temp = b.getRow(y);
					for(int i=0;i<temp.length;i++){
						if(c == temp[i] && x != i){ return false; }
					}
					
					//check the square for duplicates
					temp = b.getSqr(x, y);
					for(int i=0;i<temp.length;i++){
						int index = ((x%3)*3)+(y%3);
						if(c == temp[i] && index != i){ return false; }
					}	
				}
			}
		}
		
		return true;
	}
	
	/**
	 * For every row, check and make sure that each has (or has the possibility
	 * for) every number.  If any row does not have all, then the board is
	 * unsolvable.
	 * 
	 * @param b		The initial board
	 * @return		False if the board is unsolvable, true otherwise
	 */
	public static boolean checkRows(Board b){
	
		int[] present = new int[10];
		int[] temp;
		for(int y=0;y<9;y++){
			for(int i=0;i<10;i++){ present[i] = 0; }
			temp = b.getRow(y);
			for(int n: temp){ present[n]++; }
			for(int x=0;x<9;x++){
				if(b.get(x, y) == 0){
					temp = b.getValids(x, y);
					for(int n: temp){ present[n]++; }
				}
			}
			
			for(int i=1;i<present.length;i++){
				if(present[i] == 0){
					return false;
				}
			}
		}
		
		return true;
	}
	
	/**
	 * For every column, check and make sure that each has (or has the 
	 * possibility for) every number.  If any column does not have all, then
	 * the board is unsolvable.
	 * 
	 * @param b		The initial board
	 * @return		False if the board is unsolvable, true otherwise
	 */
	public static boolean checkCols(Board b){
		
		int[] present = new int[10];
		int[] temp;
		for(int x=0;x<9;x++){
			for(int i=0;i<10;i++){ present[i] = 0; }
			temp = b.getCol(x);
			for(int n: temp){ present[n]++; }
			for(int y=0;y<9;y++){
				if(b.get(x, y) == 0){
					temp = b.getValids(x, y);
					for(int n: temp){ present[n]++; }
				}
			}
			
			for(int i=1;i<present.length;i++){
				if(present[i] == 0){
					return false;
				}
			}
		}
		
		return true;
	}
	
	/**
	 * For every square, check and make sure that each has (or has the
	 * possibility for) every number.  If any square does not have all, then 
	 * the board is unsolvable.
	 * 
	 * @param b		The initial board
	 * @return		False if the board is unsolvable, true otherwise
	 */
	public static boolean checkSqrs(Board b){
		int[] present = new int[10];
		int[] temp;
		for(int x=0;x<9;x+=3){
			for(int y=0;y<9;y+=3){
				for(int i=0;i<10;i++){ present[i] = 0; }
				temp = b.getSqr(x, y);
				for(int n: temp){ present[n]++; }
				for(int i=0;i<3;i++){
					for(int j=0;j<3;j++){
						if(b.get(x+i, y+j) == 0){
							temp = b.getValids(x+i, y+j);
							for(int n: temp){ present[n]++; }
						}
					}
				}
				for(int i=1;i<present.length;i++){
					if(present[i] == 0){
						return false;
					}
				}
			}
		}
		
		return true;
	}
	

}
