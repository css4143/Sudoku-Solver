
/**
 * The main class of the Sudoku-Solver program.
 * 
 * @author Connor Seiden
 * @version 2-24-2015
 *
 */
public class SudokuSolver {
	
	/**
	 * The main method.  Plans to use args as inputs for a board.
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		Board board = new Board();
		Solver s = new Solver();
		
		long start = System.currentTimeMillis();
		Board solution = s.solution(board);
		long end = System.currentTimeMillis();
		
		
		if(solution!=null){
			//print solution
		}
		else{
			System.out.println("unsolvable");
		}
		System.out.print("\nRuntime for Sudoku: "+ (end-start) +" milliseconds");
		
	}

}
