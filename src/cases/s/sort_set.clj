(ns cases.s.sort_set)

;; Returns a new sorted set with supplied keys.  Any equal keys are
;; handled as if by repeated uses of conj.

(println (sorted-set 3 2 1))
(println (sorted-set 3 2 1 1))
(println #{2 1 3})
(println (apply sorted-set #{2 1 3}))

