(ns sudoku_solver.core
  (:use sudoku_solver.board)
  (:gen-class :main true))

(defn -main []
  (solve "105802000090076405200400819019007306762083090000061050007600030430020501600308900"))



