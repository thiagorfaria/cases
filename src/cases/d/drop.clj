(ns cases.d.drop)

;; Returns a lazy sequence of all but the first n items in coll.
;; Returns a stateful transducer when no collection is provided.

;; although negative (or zero) drop-item-counts are accepted they do nothing
(println (drop -1 [1 2 3 4]))
(println (drop 0 [1 2 3 4]))
(println (drop 2 [1 2 3 4]))
(println (drop 5 [1 2 3 4]))
