(ns cases.core.a.aclone)

;; Returns a clone of the Java array. Works on arrays of known
;; types.

;; create an Java integer array, then clone it
;; note that when you modify b, a remains the same
;; showing that b is not just a reference to a
;;
;; see
;;   cases.core.a.aset
;;   cases.core.i.int-array
;;   cases.core.v.vec

(def a (int-array [1 2 3 4]))
(prn a)
(prn (vec a))

(def b (aclone a))
(prn (vec b))
