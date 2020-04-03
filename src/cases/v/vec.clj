(ns cases.v.vec)

;Creates a new vector containing the contents of coll. Java arrays
;will be aliased and should not be modified.

(println (vec '(1 2 3)))
(println (vec [1 2 3]))
(println (vec #{1 2 3}))
(println (vec {:a 1 :b 2 :c 3}))
(println (vec '()))
(println (vec nil))