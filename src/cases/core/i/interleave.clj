(ns cases.core.i.interleave)

;; Returns a lazy seq of the first item in each coll, then the second etc.

(def my-keys [:fruit :color :temp])
(def my-values ["grape" "red" "hot"])
(prn (interleave my-keys my-values))
(prn (apply assoc {} (interleave my-keys my-values)))