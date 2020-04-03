(ns cases.a.aclone)

;Returns a clone of the Java array. Works on arrays of known
;types.

;; create an Java integer array, then clone it
;; note that when you modify b, a remains the same
;; showing that b is not just a reference to a
(def a (int-array [1 2 3 4]))
(println (vec a))

(def b (aclone a))
(println (vec b))
(aset b 0 23)
(println (vec a))
(println (vec b))
