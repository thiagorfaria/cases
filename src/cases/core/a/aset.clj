(ns cases.core.a.aset)

;; Sets the value at the index/indices. Works on Java arrays of
;; reference types. Returns val.
;;
;; see
;;   cases.core.i.into
;;   cases.core.i.into-array
;;   cases.core.v.vec

(def my-array (into-array Integer/TYPE [1 2 3]))

(aset my-array 1 10)

(prn (vec my-array))
(prn (into [] my-array))