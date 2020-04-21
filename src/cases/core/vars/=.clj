(ns cases.core.vars.=)

;; Equality. Returns true if x equals y, false if not. Same as
;; Java x.equals(y) except it also works for nil, and compares
;; numbers and collections in a type-independent manner.  Clojure's immutable data
;; structures define equals() (and thus =) as a value, not an identity,
;; comparison.
(println "(= 1)" (= 1))
(println "(= 1 1)" (= 1 1))
(println "(= 1 2)" (= 1 2))
(println "(= 1 1 1)" (= 1 1 1))
(println "(= 1 1 2)" (= 1 1 2))
(println "(= '(1 2) [1 2])" (= '(1 2) [1 2]))
(println (type '(1 2)) (type [1 2]))
(println "(= nil nil)" (= nil nil))
(println "(= (sorted-set 2 1) (sorted-set 1 2))" (= (sorted-set 2 1) (sorted-set 1 2)))