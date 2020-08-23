(ns cases.core.n.nth)

;; Returns the value at the index. get returns nil if index out of
;; bounds, nth throws an exception unless not-found is supplied.  nth
;; also works for strings, Java arrays, regex Matchers and Lists, and,
;; in O(n) time, for sequences.

(def my-seq ["a" "b" "c" "d"])
(prn (nth my-seq 0))
(prn (nth my-seq 1))
(try
  (prn (nth [] 0))
  (catch Exception e (prn "Exception =>" (.getMessage e))))
(prn (nth [] 0 "nothing found"))
(prn (nth [0 1 2] 77 1337))
(prn (nth ["last"] -1 "this is not perl"))