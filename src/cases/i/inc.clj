(ns cases.i.inc)

;; Returns a number one greater than num. Does not auto-promote
;; longs, will throw on overflow. See also: inc'

(println (inc 1))
(println (inc 1.0))
(println (inc 1/2))
(println (inc -1))
(println (map inc [1 2 3 4 5]))