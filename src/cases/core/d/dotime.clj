(ns cases.core.d.dotime)

;;bindings => name n
;;
;; Repeatedly executes body (presumably for side-effects) with name
;; bound to integers from 0 through n-1.

(dotimes [n 5] (println "n is" n))
(dotimes [n 10]
  (println (map #(* % (inc n)) (range 1 11))))

(dotimes [x 8]
  (print x)
  (dotimes [y x]
    (-> "Clojure" vec (get y) print))
  (newline))