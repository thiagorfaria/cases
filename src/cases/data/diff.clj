(ns cases.data.diff
  (:use [clojure.data :only (diff)]))

;; Recursively compares a and b, returning a tuple of
;; [things-only-in-a things-only-in-b things-in-both].
;; Comparison rules:
;;
;; * For equal a and b, return [nil nil a].
;; * Maps are subdiffed where keys match and values differ.
;; * Sets are never subdiffed.
;; * All sequential things are treated as associative collections
;;   by their indexes, with results returned as vectors.
;; * Everything else (including strings!) is treated as
;;   an atom and compared for equality.

(def uno {:same "same", :different "one"})
(def dos {:same "same", :different "two", :onlyhere "whatever"})
(prn "a" uno)
(prn "b" dos)

(let [value (diff uno dos)]
  (prn value)
  (prn "Things only in a" (nth value 0))
  (prn "Things only in b" (nth value 1))
  (prn "Things in both" (nth value 2)))

(def a (set [1 2 3]))
(def b (set [5 9 3 2 7]))

(println "a" a)
(println "b" b)

(let [value (diff a b)]
  (prn value)
  (println "Things only in a" (value 0))
  (println "Things only in b" (value 1))
  (println "Things in both" (value 2)))