(ns sudoku_solver.board_spec
  (:use speclj.core)
  (:use sudoku_solver.board))

(describe "board"
  
  (it "normalizes board values"
    (should= ["4" "0" "0" "0" "0" "0" "8" "0" "5" "0" "3"] 
      (get-board "40000080503")))
  
  (it "returns row index"
    (should= 0
      (row-index 7)))

  (it "returns row index"
    (should= 7 
      (col-index 7)))

  (it "returns box col number by index"
    (should= 2 
      (box-col-number 7)))

  (it "returns box starting index"
    (should= 0 
      (box-col-number 10)))

  (it "returns box row number"
    (should= 1 
      (box-row-number 28)))

  (it "returns box starting index 27"
    (should= 27 
      (box-starting-index 28)))

  (it "returns box starting index 30"
    (should= 30 
      (box-starting-index 31)))

  (it "returns box starting index 0"
    (should= 0 
      (box-starting-index 10)))

  (it "returns true if value equals zero"
    (should= true 
      (open-space "0")))

  (it "returns false if value does not equal zero"
    (should= false 
      (open-space "1")))

  (it "returns false if board contains 0 spaces"
    (should= false 
      (solved '("0" "1" "2" "4" "0"))))

  (it "returns true if board contains 0 spaces"
    (should= true 
      (solved '("5" "1" "2" "4" "9"))))

  (let [board (get-board "105802000090076405200400819019007306762083090000061050007600030430020501600308900")]
    (it "returns all row 0 values"
      (should= '("1" "0" "5" "8" "0" "2" "0" "0" "0") 
        (row-values board 0))))

  (let [board (get-board "105802000090076405200400819019007306762083090000061050007600030430020501600308900")]
    (it "returns all row 1 values"
      (should= '("0" "9" "0" "0" "7" "6" "4" "0" "5") 
        (row-values board 9))))

  (let [board (get-board "105802000090076405200400819019007306762083090000061050007600030430020501600308900")]
    (it "returns all col 0 values"
      (should= '("1" "0" "2" "0" "7" "0" "0" "4" "6") 
        (col-values board 0))))

  (let [board (get-board "105802000090076405200400819019007306762083090000061050007600030430020501600308900")]
    (it "returns all col 6 values"
      (should= '("0" "4" "8" "3" "0" "0" "0" "5" "9")
        (col-values board 6))))

  (let [board (get-board "105802000090076405200400819019007306762083090000061050007600030430020501600308900")]
    (it "returns all box 0 values"
      (should= '("1" "0" "5" "0" "9" "0" "2" "0" "0")
        (box-values board, 0))))

  (let [board (get-board "105802000090076405200400819019007306762083090000061050007600030430020501600308900")]
    (it "returns all box 5 values"
      (should= '("0", "0", "7", "0", "8", "3", "0", "6", "1")
        (box-values board, 30))))

  (let [board (get-board "105802000090076405200400819019007306762083090000061050007600030430020501600308900")]
    (it "returns all taken values for index 1"
      (should= '("1" "2" "3" "5" "6" "8" "9")
        (sort (all-taken-values board, 1)))))

(let [board (get-board "105802000090076405200400819019007306762083090000061050007600030430020501600308900")]
    (it "returns all untaken values for index 1"
      (should= '("4" "7")
        (sort (possible-moves board, 1)))))

(let [board (get-board "105802000090076405200400819019007306762083090000061050007600030430020501600308900")]
    (it "adds move to board"
      (should= (vec (get-board "105802000090176405200400819019007306762083090000061050007600030430020501600308900"))
        (place-value-on-board board, 12))))

(let [board (get-board "105802000090076405200400819019007306762083090000061050007600030430020501600308900")]
    (it "returns false when a move cannot be made"
      (should= false
        (make-move board 1))))

(let [board (get-board "105802000090076405200400819019007306762083090000061050007600030430020501600308900")]
    (it "returns true when a move can be made"
      (should= true 
        (make-move board 12))))


)
 
  
