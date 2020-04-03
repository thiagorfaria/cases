(ns cases.r.range)

;; Returns a lazy seq of nums from start (inclusive) to end
;; (exclusive), by step, where start defaults to 0, step to 1, and end to
;; infinity. When step is equal to 0, returns an infinite sequence of
;; start. When start is equal to end, returns empty list.

;; default value of 'end' is infinity
;(println (range))
;; Since clojure 1.2:
(println (take 10 (range)))
(println (range 10))
(println (range -5 5))
(println (range -100 100 10))
(println (range 0 4 2))
(println (range 0 5 2))
(println (range 0 6 2))
(println (range 0 7 2))
(println (range 100 0 -10))
(println (range 10 -10 -1))