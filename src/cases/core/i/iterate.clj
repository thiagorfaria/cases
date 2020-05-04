(ns cases.core.i.iterate)


;; Returns a lazy sequence of x, (f x), (f (f x)) etc. f must be free of side-effects

;; limit results
(println (take 5 (iterate inc 5)))
(println (take 10 (iterate (partial + 2) 0)))
(println (take 20 (iterate (partial + 2) 0)))

(def powers-of-two (iterate (partial * 2) 1))
(println (nth powers-of-two 10))
(println (take 10 powers-of-two))

(def fib (map first (iterate (fn [[a b]] [b (+' a b)]) [0 1])))
(println (take 10 fib))

(defn pi
  "Approximate Pi to the 1/n decimal with Leibniz formula"
  [n]
  (transduce
    (comp (map #(/ 4 %)) (take n))
    +
    (iterate #(* ((if (pos? %) + -) % 2) -1) 1.0)))

(println (time (pi 1e8)))