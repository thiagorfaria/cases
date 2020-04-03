(ns cases.t.take)

;; Returns a lazy sequence of the first n items in coll, or all items if
;; there are fewer than n.  Returns a stateful transducer when
;; no collection is provided.
;; return a lazy seq of the first 3 items
(println (take 3 '(1 2 3 4 5 6)))
(println (take -1 '(1 2 3 4 5 6)))
(println (take 3 [1 2 3 4 5 6]))
;; returns all items if there are fewer than n
(println (take 3 [1 2]))
(println (take 1 []))
(println (take 1 nil))
(println (take 0 [1]))
(println (take -1 [1]))

;; similar to subvec but lazy and with seqs
(println (range 1 11))
(println (drop 5 (range 1 11)))
(println (take 3 (drop 5 (range 1 11))))