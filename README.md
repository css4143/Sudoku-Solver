# Sudoku-Solver
The back end of a sudoku solver

Author: Connor Seiden

This code is for the back end of a sudoku solver that will take an incomplete sukdoku board and find the solution, if one exists.  As this is only the back end, there is an example main method that will allow it to be run through standard i/o, but there is no dedicated UI.  If you wish to use a version that has a UI, please see my Sudoku-Solver-Android project.

The program finds the solution to a sudoku board through the use of a modified backtracking algorithm.  It recursively searches through valid board configurations until a complete, valid board is found.

This new version implements code that checks the initial board state to see if it is solvable or not.  This was implemented to deal with sparse, unsolvable graphs which the program was having long run times for.


To run this program, the main method is in SudokuSolver.java 

SudokuSolver currently has an example board that it solves.
