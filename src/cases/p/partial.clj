(ns cases.p.partial)

;; Takes a function f and fewer than the normal arguments to f, and
;; returns a fn that takes a variable number of additional args. When
;; called, the returned function calls f with args + additional args.


(def to-english (partial clojure.pprint/cl-format nil "~@(~@[~R~]~^ ~A.~)"))
(println (to-english 1234567890))

(def times (partial *))
(println (times 1))
(println (times 1 2 3))
(println (* 1 2 3))

(def add-hundred (partial + 100))
(println (add-hundred 1))
(println (add-hundred 1 2 3))
(println (+ 100 1 2 3))

(def remove-fifty (partial - 50))
(println (remove-fifty 1))
(println (remove-fifty 1 2 3))
(println (- 50 1 2 3))