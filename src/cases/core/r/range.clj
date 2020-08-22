(ns cases.core.r.range)

;; Returns a lazy seq of nums from start (inclusive) to end
;; (exclusive), by step, where start defaults to 0, step to 1, and end to
;; infinity. When step is equal to 0, returns an infinite sequence of
;; start. When start is equal to end, returns empty list.

;; default value of 'end' is infinity
;(println (range))
;; Since clojure 1.2:
(prn "10 (range)" (take 10 (range)))
(prn "10" (range 10))
(prn "-5 5" (range -5 5))
(prn "-100 100 10" (range -100 100 10))
(prn "0 4 2" (range 0 4 2))
(prn "0 5 2" (range 0 5 2))
(prn "0 6 2" (range 0 6 2))
(prn "0 7 2" (range 0 7 2))
(prn "100 0 -10" (range 100 0 -10))
(prn "10 -10 -1" (range 10 -10 -1))
