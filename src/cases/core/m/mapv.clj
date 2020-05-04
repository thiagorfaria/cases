(ns cases.core.m.mapv)

;; Returns a vector consisting of the result of applying f to the
;; set of first items of each coll, followed by applying f to the set
;; of second items in each coll, until any one of the colls is
;; exhausted.  Any remaining items in other colls are ignored. Function
;; f should accept number-of-colls arguments.

(println (mapv inc [1 2 3 4 5]))
(println (mapv + [1 2 3] [4 5 6]))
(println (mapv + [1 2 3] [4 5]))

(prn (mapv #(str "Hello " % "!") ["Ford" "Arthur" "Tricia"]))

(prn (mapv + [1 2 3] (iterate inc 1)))