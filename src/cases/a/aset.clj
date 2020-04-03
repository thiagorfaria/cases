(ns cases.a.aset)

;; Sets the value at the index/indices. Works on Java arrays of
;; reference types. Returns val.

(def my-array (into-array Integer/TYPE [1 2 3]))

(aset my-array 1 10)

(println (vec my-array))
(println (into [] my-array))