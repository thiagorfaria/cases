(ns cases.n.nth)

;; Returns the value at the index. get returns nil if index out of
;; bounds, nth throws an exception unless not-found is supplied.  nth
;; also works for strings, Java arrays, regex Matchers and Lists, and,
;; in O(n) time, for sequences.

(def my-seq ["a" "b" "c" "d"])
(println (nth my-seq 0))
(println (nth my-seq 1))
(try
  (println (nth [] 0))
  (catch Exception e
    (println "Exception =>" e)
    (println)))
(println (nth [] 0 "nothing found"))
(println (nth [0 1 2] 77 1337))
(println (nth ["last"] -1 "this is not perl"))