(ns cases.core.vars.*)

;; Returns the product of nums. (*) returns 1. Does not auto-promote
;; longs, will throw on overflow. See also: *'
(println "(*)" (*))
(println "(* 6)" (* 6))
(println "(* 2 3)" (* 2 3))
(println "(* 2 3 4)" (* 2 3 4))
(println "(* 0.5 200)" (* 0.5 200))