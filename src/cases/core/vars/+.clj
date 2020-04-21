(ns cases.core.vars.+)

;; Returns the sum of nums. (+) returns 0. Does not auto-promote
;; longs, will throw on overflow. See also: +'
(println "(+)" (+))
(println "(+ 1)" (+ 1))
(println "(+ -10)" (+ -10))
(println "(+ 1 2)" (+ 1 2))
(println "(+ 1 2 3)" (+ 1 2 3))