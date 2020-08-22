(ns cases.core.r.reduce)

;; f should be a function of 2 arguments. If val is not supplied,
;; returns the result of applying f to the first 2 items in coll, then
;; applying f to that result and the 3rd item, etc. If coll contains no
;; items, f must accept no arguments as well, and reduce returns the
;; result of calling f with no arguments.  If coll has only 1 item, it
;; is returned and f is not called.  If val is supplied, returns the
;; result of applying f to val and the first item in coll, then
;; applying f to that result and the 2nd item, etc. If coll contains no
;; items, returns val and f is not called.

(prn "reduce + [1 2 3 4 5] = " (reduce + [1 2 3 4 5]))
(prn "reduce + [] = " (reduce + []))
(prn "reduce + [1] = " (reduce + [1]))
(prn "reduce + [1 2] = " (reduce + [1 2]))
(prn "reduce + 1 [] = " (reduce + 1 []))
(prn "reduce + 1 [2 3] = " (reduce + 1 [2 3]))

;; Add one collection to another (combining sequences is done with cons):
(reduce conj [1 2 3] [4 5 6])

;; A simple factorial function using reduce:
(defn fact [x]
  (reduce * (range 1 (inc x))))

(prn (fact 4))
