(defproject sudoku_solver "0.1.0-SNAPSHOT"
  :description "Sudoku Solver Kata"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :profiles {:dev {:dependencies [[speclj "3.0.1"]]}}
  :plugins [[speclj "3.0.1"] [speclj-growl "1.0.0-SNAPSHOT"]]
  :test-paths ["spec"]
  :main sudoku_solver.core
  :java-source-path "src/")
