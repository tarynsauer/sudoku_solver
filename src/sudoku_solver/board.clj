(ns sudoku_solver.board
(:use clojure.string))

(defn parse-values [values] 
  (map #(Integer/parseInt %) (remove clojure.string/blank? values))) 

(defn get-board [values]
   (parse-values (clojure.string/split (clojure.string/replace values #"\." "0") #"")))

(defn used-row-numbers [row-number board]
  (remove zero? (subvec board row-number (+ (* row-number 9) 9))))





