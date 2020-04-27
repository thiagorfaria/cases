(ns cases.core.i.into)

;; Returns a new coll consisting of to-coll with all of the items of
;; from-coll conjoined. A transducer may be supplied.

; Maps can be constructed from a sequence of 2-vectors or a sequence
; of maps
(println (into (sorted-map) [[:a 1] [:c 3] [:b 2]]))
{:a 1, :b 2, :c 3}
(println (into (sorted-map) [{:a 1} {:c 3} {:b 2}]))
{:a 1, :b 2, :c 3}

; When maps are the input source, they convert into an unordered sequence
; of key-value pairs, encoded as 2-vectors
(println (into [] {1 2, 3 4}))
[[1 2] [3 4]]

; Test
(println '(1 2 3 4 5 1))
(println (into (sorted-set) '(1 2 3 4 5 1)))
(println (into '(0 9 8 7) '(1 2 3 4 5 1)))

; This does not happen for a vector, however, due to the behavior of conj:
(println (into [1 2 3] '(4 5 6)))


