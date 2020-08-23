d(ns cases.core.i.interate)

;; Returns a lazy sequence of x, (f x), (f (f x)) etc. f must be free of side-effects

;; limit results
(println (drop 5 (range 10)))
(println (take 5 (iterate inc 5)))
(println (take 10 (iterate (partial + 2) 0)))
(println (take 20 (iterate (partial + 2) 0)))

(def powers-of-two (iterate (partial * 2) 1))
(println (nth powers-of-two 10))
(println (take 11 powers-of-two))

;; demonstrating the power of iterate
;; to generate the Fibonacci sequence
;; uses +' to promote to BigInt
;; TODO
(def fib (map first (iterate (fn [[a b]] [b (+' a b)]) [0 1])))
(println (take 10 fib))