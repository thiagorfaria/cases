(ns cases.core.d.disj)

;; disj[oin]. Returns a new set of the same (hashed/sorted) type, that
;; does not contain key(s).
(println (disj #{1 2 3}))
(println (disj #{1 2 3} 2))
(println (disj #{1 2 3} 4))
(println (disj #{1 2 3} 1 3))