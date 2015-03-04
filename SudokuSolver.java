
/**
 * The main class of the Sudoku-Solver program.
 * 
 * Enter "test" as the first command line argument to use a test puzzle for
 * debug or demonstration purposes.
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
		if (args.length>0 && args[0].equals("test")){
			board.put(3,1,0);
			board.put(8,3,0);
			board.put(9,0,1);
			board.put(5,2,1);
			board.put(6,3,1);
			board.put(7,6,1);
			board.put(1,2,2);
			board.put(9,4,2);
			board.put(3,5,2);
			board.put(2,6,2);
			board.put(8,0,3);
			board.put(6,2,3);
			board.put(5,3,3);
			board.put(4,1,4);
			board.put(3,4,4);
			board.put(4,0,6);
			board.put(7,1,6);
			board.put(2,2,6);
			board.put(3,3,6);
			board.put(6,5,6);
			board.put(9,6,6);
			board.put(5,7,6);
			board.put(1,1,7);
			board.put(9,2,7);
			board.put(4,3,7);
			board.put(8,4,7);
			board.put(7,5,7);
			board.put(6,7,7);
			board.put(3,0,8);
			board.put(6,1,8);
			board.put(8,2,8);
			board.put(2,3,8);
			board.put(5,4,8);
			board.put(9,5,8);
			board.put(1,7,8);
			
			System.out.println("Initial Board:");
			board.printBoard();
		}
		
		System.out.print("\n\n");
		
		Solver s = new Solver();
		
		long start = System.currentTimeMillis();
		Board solution = s.solution(board);
		long end = System.currentTimeMillis();
		
		
		if(solution!=null){
			System.out.println("Solution:");
			solution.printBoard();
		}
		else{
			System.out.println("unsolvable");
		}
		System.out.print("\nRuntime for Sudoku: "+ (end-start) +" milliseconds");
		
	}

}
