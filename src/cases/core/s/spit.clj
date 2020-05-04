(ns cases.core.s.spit)

;; Opposite of slurp.  Opens f with writer, writes content, then
;; closes f. Options passed to clojure.java.io/writer.

(spit "/Users/thiagofaria/Work/workspace/cases/resources/chap1.txt" "\n test 1\n" :append true)
(println (slurp "/Users/thiagofaria/Work/workspace/cases/resources/chap1.txt"))