(ns cases.core.vars.-)

;; If no ys are supplied, returns the negation of x, else subtracts
;; the ys from x and returns the result. Does not auto-promote
;; longs, will throw on overflow. See also: -'
(println "(- 1)" (- 1))
(println "(- -10)" (- -10))
(println "(- 1 2)" (- 1 2))
(println "(- 1 2 3)" (- 1 2 3))