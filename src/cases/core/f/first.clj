(ns cases.core.f.first)

;; Returns the first item in the collection. Calls seq on its
;; argument. If coll is nil, returns nil.

(println (first '(:alpha :bravo :charlie)))
(println (first nil))
(println (first []))
(println (first [nil]))
(println (first [[1 2] [3 4]]))