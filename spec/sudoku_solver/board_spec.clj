(ns sudoku_solver.board_spec
  (:use speclj.core)
  (:use sudoku_solver.board))

(describe "board"
  (it "normalizes board values"
    (should= [4 0 0 0 0 0 8 0 5 0 3] 
      (get-board "40000080503")))

  (it "returns all used numbers in the row"
    (should= '(3 2 6 9 5)
      (used-row-numbers 0 [3 0 2 6 0 9 0 0 5 5 0 0 7 3 0 0 0 0 0 0 0 0 0 0 9 0 0 0 0 0 9 4 0 0 0 0 0 0 0 0 0 0 1 0 9 0 0 0 0 5 7 0 6 0 0 0 8 5 0 0 0 0 6 0 0 0 0 0 0 0 0 3 0 1 9 0 8 2 0 4 0]))))


  
