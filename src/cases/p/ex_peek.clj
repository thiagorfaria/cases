(ns cases.p.ex_peek)

;; For a list or queue, same as first, for a vector, same as, but much
;; more efficient than, last. If the collection is empty, returns nil.

(def large-vec (vec (range 0 10000)))
(println (time (last large-vec)))
(println (time (peek large-vec)))

(println (peek [1 2 3 4]))
(println (peek []))
(println (peek '(1 2 3 4)))
(println (peek '()))
(println (peek nil))
