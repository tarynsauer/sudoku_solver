(ns sudoku_solver.board
(:require [clojure.string :refer [blank? split]])
(:require [clojure.set :refer [difference]]))

(def options #{"1" "2" "3" "4" "5" "6" "7" "8" "9"})

(defn get-board [puzzle]
  (remove clojure.string/blank? (clojure.string/split puzzle #"")))

(defn row-index [index]
  (int (float (/ index 9))))
 
(defn col-index [index]
  (mod index 9))

(defn box-col-number [index]
  (int (float (/ (col-index index) 3))))

(defn box-row-number [index]
  (int (float (/ index 27))))

(defn box-starting-index [index]
  (+ (* 27 (box-row-number index)) (* 3 (box-col-number index))))

(defn open-space [value] 
  (= value "0"))

(defn solved [board] 
  (nil? (some #{"0"} board)))

(defn row-values [board, index] 
  (let [begin-index (* (row-index index) 9)]
    (drop begin-index (take (+ 9 begin-index) board))))

(defn col-values [board, index] 
  (keep-indexed #(if (= (col-index index) (col-index %1)) %2) board))

(defn box-values [board, box-index] 
  (loop [box '(), box-index box-index, board board]
    (let [box (concat box (drop box-index (take (+ box-index 3) board)))] 
      (if (= (count box) 9)
        (do box)
        (recur box (+ box-index 9) board)))))

(defn all-taken-values [board, index] 
  (let [all-vals (concat (box-values board (box-starting-index index)) (row-values board index) (col-values board index))]
   (remove #{"0"} (distinct all-vals))))

(defn possible-moves [board, index]
  (clojure.set/difference options (all-taken-values board index)))

(defn place-value-on-board [board, index]
  (let [board (vec board) move (first (possible-moves board index))]
    (assoc board index move)))

(defn make-move [board, index]
  (= (count (possible-moves board index)) 1))

(defn make-move-if-possible [board, index, move]
  (if (and (open-space board, index) (make-move board, index))
    (place-value-on-board board index)))

(defn solve [puzzle]
  (let [board (get-board puzzle)]
    (loop [board board index 0]
      (let [board board] 
        (for [cell board] (make-move-if-possible board (inc index)))
         (print board)
         (if (solved board)
            (println board)
            (recur board 0)))))) 
